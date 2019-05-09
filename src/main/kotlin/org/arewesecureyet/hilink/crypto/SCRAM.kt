package org.arewesecureyet.hilink.crypto

import org.apache.commons.codec.binary.Hex
import org.bouncycastle.crypto.digests.SHA256Digest
import org.bouncycastle.crypto.generators.PKCS5S2ParametersGenerator
import org.bouncycastle.crypto.macs.HMac
import org.bouncycastle.crypto.params.KeyParameter
import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import java.security.SecureRandom
import kotlin.experimental.xor

class SCRAM {
    val secureRandom: SecureRandom = SecureRandom.getInstance("NativePRNG")
    var clientNonce: String
    //private set
    private var serverNonce: String? = null
    private var salt: ByteArray? = null
    private var iterations: Int = 0

    constructor(nonceSize: Int) {
        var buf = ByteArray(nonceSize)
        this.secureRandom.nextBytes(buf)

        this.clientNonce = Hex.encodeHexString(buf);
    }

    fun setParameter(serverNonce: String, salt: String, iterations: Int) {
        this.serverNonce = serverNonce
        this.salt = Hex.decodeHex(salt.toCharArray())
        this.iterations = iterations
    }

    fun getClientProof(password: String): String {
        val macKey = "${this.clientNonce},${this.serverNonce},${this.serverNonce}"

        val pbkdf2Hmac = PKCS5S2ParametersGenerator(SHA256Digest())
        pbkdf2Hmac.init(password.toByteArray(StandardCharsets.UTF_8), salt, iterations)
        val hashedPass = (pbkdf2Hmac.generateDerivedParameters(256) as KeyParameter).key

        val hmac = HMac(SHA256Digest())
        var clientKey = ByteArray(hmac.macSize)
        hmac.init(KeyParameter("Client Key".toByteArray()))
        hmac.update(hashedPass, 0, hashedPass.size)
        hmac.doFinal(clientKey, 0)

        val sha256 = MessageDigest.getInstance("SHA-256")
        sha256.update(clientKey)
        val storedKey = sha256.digest()

        val sigHmac = HMac(SHA256Digest())
        val signature = ByteArray(sigHmac.macSize)
        sigHmac.init(KeyParameter(macKey.toByteArray(StandardCharsets.UTF_8)))
        sigHmac.update(storedKey, 0, storedKey.size)
        sigHmac.doFinal(signature, 0)

        val proof = ByteArray(signature.size)
        for (i in 0 until signature.size) {
            proof[i] = clientKey[i] xor signature[i]
        }

        return Hex.encodeHexString(proof)
    }
}
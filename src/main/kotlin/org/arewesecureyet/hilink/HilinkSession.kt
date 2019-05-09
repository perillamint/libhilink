package org.arewesecureyet.hilink

import okhttp3.*
import org.arewesecureyet.hilink.crypto.SCRAM
import org.arewesecureyet.hilink.error.HilinkAPIError
import org.arewesecureyet.hilink.error.HilinkAuthenticationError
import org.arewesecureyet.hilink.xmlobject.response.*
import org.arewesecureyet.hilink.xmlobject.request.*
import java.io.InputStream
import java.io.StringWriter
import java.net.URL
import java.time.Duration
import javax.xml.bind.JAXBContext
import javax.xml.bind.Marshaller

class HilinkSession {
    private val baseUrl: URL
    private var client: OkHttpClient
    private var csrfToken: String? = null
    private var scram: SCRAM = SCRAM(32)

    constructor(baseUrl: String, timeout: Duration) {
        this.baseUrl = URL(baseUrl);
        this.client = OkHttpClient.Builder()
            .readTimeout(timeout)
            .writeTimeout(timeout)
            .cookieJar(HilinkCookieJar())
            .followRedirects(false)
            .build()

        val token = this.get("/api/webserver/SesTokInfo", SesTokResponse::class.java)
        this.csrfToken = token.token
    }

    private fun runCall(call: Call): Response {
        val response = call.execute();
        this.updateCsrfToken(response.headers())
        return response
    }

    private fun updateCsrfToken(headers: Headers) {
        val token = headers.get("__RequestVerificationToken")
        if (token != null) {
            this.csrfToken = token
        }
    }

    private fun getRequestBuilder(path: String): Request.Builder {
        var builder = Request.Builder()
            .url(URL(this.baseUrl, path))

        if (this.csrfToken != null) {
            builder = builder.addHeader("__RequestVerificationToken", this.csrfToken!!)
        }

        return builder
    }

    private fun <T>parseHilinkXML(stream: InputStream, clazz: Class<T>): T {
        val unmarshaller = JAXBContext.newInstance(
            clazz,
            HilinkErrorResponse::class.java
        ).createUnmarshaller()

        var res = unmarshaller.unmarshal(stream)

        if (res is HilinkErrorResponse) {
            if (res.msg == "") {
                res.msg = "Unknown"
            }
            throw HilinkAPIError(res.code ?: 0, res.msg ?: "Unknown")
        } else {
            @Suppress("UNCHECKED_CAST")
            return res as T
        }
    }

    private fun <T>generateHilinkXML(obj: T, clazz: Class<T>): String {
        val stream = StringWriter()
        val marshaller = JAXBContext.newInstance(clazz).createMarshaller()
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true)
        marshaller.marshal(obj, stream)
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>$stream"
    }

    fun get(path: String): Response {
        val call = this.client.newCall(this.getRequestBuilder(path).get().build())
        return this.runCall(call)
    }

    fun <T>get(path: String, clazz: Class<T>): T {
        this.get(path).body()!!.byteStream().use {
            return this.parseHilinkXML(it, clazz)
        }
    }

    fun post(path: String, body: String, brokenAPI: Boolean = false): Response {
        var mediaType = MediaType.parse("text/xml")
        if (brokenAPI) {
            mediaType = MediaType.parse("application/x-www-form-urlencoded; charset=UTF-8")
        }

        val request = this.getRequestBuilder(path)
            .post(RequestBody.create(mediaType, body))
            .build()

        val call = this.client.newCall(request)
        return this.runCall(call)
    }

    fun <T>post(path: String, body: String, clazz: Class<T>, brokenAPI: Boolean = false): T {
        this.post(path, body, brokenAPI).body()!!.byteStream().use {
            return this.parseHilinkXML(it, clazz)
        }
    }

    fun <T, E>post(path: String, body: E, bodyClazz: Class<E>, clazz: Class<T>, brokenAPI: Boolean = false): T {
        var bodyXML = this.generateHilinkXML(body, bodyClazz)
        return this.post(path, bodyXML, clazz, brokenAPI)
    }

    fun login(username: String, password: String): AuthenticationResponse {
        val loginState = this.get("api/user/state-login", LoginStateResponse::class.java)
        if (loginState.externPasswordType == 1) {
            val challengeRequest = LoginChallengeRequest()
            challengeRequest.username = username
            challengeRequest.nonce = scram.clientNonce
            challengeRequest.mode = 1 // RSA_LOGIN_MODE
            val challenge = this.post(
                "/api/user/challenge_login",
                challengeRequest,
                LoginChallengeRequest::class.java,
                LoginChallengeResponse::class.java
            )

            scram.setParameter(challenge.serverNonce!!, challenge.salt!!, challenge.iterations!!)
            val proof = scram.getClientProof(password)

            val authRequest = AuthenticationRequest()
            authRequest.clientProof = proof
            authRequest.finalNonce = challenge.serverNonce!!

            return this.post(
                "/api/user/authentication_login",
                authRequest,
                AuthenticationRequest::class.java,
                AuthenticationResponse::class.java,
                false
            )
        } else {
            throw HilinkAuthenticationError("Not yet implemented")
        }
    }
}
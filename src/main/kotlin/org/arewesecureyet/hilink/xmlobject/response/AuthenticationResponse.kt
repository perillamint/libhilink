package org.arewesecureyet.hilink.xmlobject.response

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

/*
<?xml version="1.0" encoding="UTF-8"?>
<response>
<rsan>a98c60db75a5b1d53eb0341f2153f60aed8588333c0b4b3e6c88b3c66dea6ccfbc0b0da3eea96278cd7faf5bda27dd13c321a0112c9e358a623abaeecabd297a1738a97532c6fc9bc0373c711b80df869131a9811cec8a59d5d1b7e95d769b209dd067ef6dbcf6f85ba7f2d3f526082b2044fada175c28d61aa93824bfa61294ded592751f3827589dbcc1dd6e6367f7df4cda293791985f7a4279f558e002e6d8f1f432c7018a799681356ae3fcd6e12f682ced8d4fcd1712a5b6b307b4dbc200e981ed1b2eb48ec55fddc2adc4609048b89eb29b8545064aa724d7a136dc46f889f30fc8febc62fbe61a2399965718dd1b41d9493bc2bbc4917ca936968aef</rsan><rsae>010001</rsae>
<serversignature>43442b32c944c1be7e85a14d1f71d9d2cbb123bfd5d1de22993993ec62218d8c</serversignature>
<rsapubkeysignature>a9cc33ba4b4efa4622cc3f9c38a538da4e94fe1a92df7b029ceb9cbbad4453e1</rsapubkeysignature>
</response>
 */
@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
class AuthenticationResponse {
    @XmlElement(name = "rsan")
    var rsan: String? = null

    @XmlElement(name = "serversignature")
    var serverSignature: String? = null

    @XmlElement(name = "rsapubkeysignature")
    var rsaPubkeySignature: String? = null
}
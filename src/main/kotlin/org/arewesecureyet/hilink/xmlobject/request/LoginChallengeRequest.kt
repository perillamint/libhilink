package org.arewesecureyet.hilink.xmlobject.request

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement(name = "request")
@XmlAccessorType(XmlAccessType.FIELD)
class LoginChallengeRequest {
    @XmlElement(name = "username")
    var username: String = ""

    @XmlElement(name = "firstnonce")
    var nonce: String = ""

    @XmlElement(name = "mode")
    var mode: Int = 1 // RSA_LOGIN_MODE
}
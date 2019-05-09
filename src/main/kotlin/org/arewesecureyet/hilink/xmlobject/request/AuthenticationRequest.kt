package org.arewesecureyet.hilink.xmlobject.request

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement(name = "request")
@XmlAccessorType(XmlAccessType.FIELD)
class AuthenticationRequest {
    @XmlElement(name = "clientproof")
    var clientProof: String? = null

    @XmlElement(name = "finalnonce")
    var finalNonce: String? = null
}
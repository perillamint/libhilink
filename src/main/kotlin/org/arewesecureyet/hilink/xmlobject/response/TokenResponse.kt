package org.arewesecureyet.hilink.xmlobject.response

import javax.xml.bind.annotation.*

@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
class TokenResponse {
    @XmlElement(name = "token")
    val token: String? = null
}

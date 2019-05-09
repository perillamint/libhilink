package org.arewesecureyet.hilink.xmlobject.response

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
class SesTokResponse {
    @XmlElement(name = "TokInfo")
    var token: String? = ""

    @XmlElement(name = "SesInfo")
    var sessionId: String? = ""
}
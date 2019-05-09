package org.arewesecureyet.hilink.xmlobject.response

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement(name = "error")
@XmlAccessorType(XmlAccessType.FIELD)
class HilinkErrorResponse {
    @XmlElement(name = "code")
    var code: Int? = 0

    @XmlElement(name = "message")
    var msg: String? = ""
}
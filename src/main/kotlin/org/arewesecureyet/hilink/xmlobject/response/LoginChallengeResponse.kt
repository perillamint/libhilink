package org.arewesecureyet.hilink.xmlobject.response

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

/*
<?xml version="1.0" encoding="UTF-8"?>
<response>
<iterations>100</iterations>
<servernonce>baac3e2e175c426f82b26b3dea6785d7e56a7e865eb7435abab2dcf14a395e5avx05zoufS2HHs3H300EJokPtKd0ATd9O</servernonce>
<modeselected>1</modeselected>
<salt>415b3bf74bc452313604b73cfb22c76615f6607a121d190377a5a2bec1794956</salt>
<newType>0</newType>
</response>
 */

@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
class LoginChallengeResponse {
    @XmlElement(name = "iterations")
    var iterations: Int? = 0

    @XmlElement(name = "servernonce")
    var serverNonce: String? = null

    @XmlElement(name = "modeselected")
    var modeSelected: Int? = 0

    @XmlElement(name = "salt")
    var salt: String? = null

    @XmlElement(name = "newType")
    var newType: Int? = 0
}
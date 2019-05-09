package org.arewesecureyet.hilink.xmlobject.response

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

/*
<?xml version="1.0" encoding="UTF-8"?>
<response>
<username></username>
<password_type>4</password_type>
<firstlogin>1</firstlogin>
<history_login_flag>0</history_login_flag>
<wifipwdsamewithwebpwd>0</wifipwdsamewithwebpwd>
<extern_password_type>1</extern_password_type>
<State>-1</State>
<userlevel></userlevel>
</response>
 */

@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
class LoginStateResponse {
    @XmlElement(name = "Username")
    var username: String? = null

    @XmlElement(name = "password_type")
    var passwordType: Int? = 0

    @XmlElement(name = "firstlogin")
    var firstlogin: Int? = 0

    @XmlElement(name = "history_login_flag")
    var historyLoginFlag: Int? = 0

    @XmlElement(name = "wifipwdsamewithwebpwd")
    var wifiPassIsWebPass: Int? = 0

    @XmlElement(name = "extern_password_type")
    var externPasswordType: Int? = 0

    @XmlElement(name = "State")
    var state: Int? = 0

    @XmlElement(name = "userlevel")
    var userlevel: Int? = 0
}
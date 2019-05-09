package org.arewesecureyet.hilink.xmlobject.response

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

/*
<ConnectionStatus>901</ConnectionStatus>
<WifiConnectionStatus>902</WifiConnectionStatus>
<SignalStrength></SignalStrength>
<SignalIcon>5</SignalIcon>
<CurrentNetworkType>19</CurrentNetworkType>
<CurrentServiceDomain>2</CurrentServiceDomain>
<RoamingStatus>0</RoamingStatus>
<BatteryStatus>0</BatteryStatus>
<BatteryLevel>4</BatteryLevel>
<BatteryPercent>92</BatteryPercent>
<simlockStatus>0</simlockStatus>
<PrimaryDns>1.0.0.1</PrimaryDns>
<SecondaryDns>1.1.1.1</SecondaryDns>
<PrimaryIPv6Dns></PrimaryIPv6Dns>
<SecondaryIPv6Dns></SecondaryIPv6Dns>
<CurrentWifiUser>2</CurrentWifiUser>
<TotalWifiUser>16</TotalWifiUser>
<currenttotalwifiuser>10</currenttotalwifiuser>
<ServiceStatus>2</ServiceStatus>
<SimStatus>1</SimStatus>
<WifiStatus>1</WifiStatus>
<CurrentNetworkTypeEx>101</CurrentNetworkTypeEx>
<WanPolicy>0</WanPolicy>
<maxsignal>5</maxsignal>
<wifiindooronly>0</wifiindooronly>
<wififrequence>1</wififrequence>
<classify>mobile-wifi</classify>
<flymode>0</flymode>
<cellroam>1</cellroam>
<usbup>0</usbup>
 */

@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
class StatusResponse {
    @XmlElement(name = "ConnectionStatus")
    val connectionStatus: Int? = 0

    @XmlElement(name = "WiFiConnectionStatus")
    val wifiConnectionStatus: Int? = 0

    @XmlElement(name = "SignalStrength")
    val signalStrength: String? = null

    @XmlElement(name = "SignalIcon")
    val signalIcon: Int? = 0

    @XmlElement(name = "CurrentNetworkType")
    val currentNetworkType: Int? = 0

    @XmlElement(name = "CurrentServiceDomain")
    val currentServiceDomain: Int? = 0

    @XmlElement(name = "RoamingStatus")
    val roamingStatus: Int? = 0

    @XmlElement(name = "BatteryStatus")
    val batteryStatus: Int? = 0

    @XmlElement(name = "BatteryLevel")
    val batteryLevel: Int? = 0

    @XmlElement(name = "BatteryPercent")
    val batteryPercent: Int? = 0

    @XmlElement(name = "smlockStatus")
    val simlockStatus: Int? = 0

    @XmlElement(name = "PrimaryDns")
    val primaryDns: String? = null

    @XmlElement(name = "SecondaryDns")
    val secondaryDns: String? = null

    @XmlElement(name = "PrimaryIPv6Dns")
    val primaryIPv6Dns: String? = null

    @XmlElement(name = "SecondaryIPv6Dns")
    val secondaryIPv6Dns: String? = null

    @XmlElement(name = "CurrentWifiUser")
    val currentWiFiUsers: Int? = 0

    @XmlElement(name = "TotalWifiUser")
    val maxWiFiUsers: Int? = 0

    @XmlElement(name = "currenttotalwifiuser")
    val currentTotalWiFiUsers: Int? = 0

    @XmlElement(name = "ServiceStatus")
    val serviceStatus: Int? = 0

    @XmlElement(name = "SimStatus")
    val simStatus: Int? = 0

    @XmlElement(name = "WifiStatus")
    val wifiStatus: Int? = 0

    @XmlElement(name = "CurrentNetworkTypeEx")
    val currentNetworkTypeEx: Int? = 0

    @XmlElement(name = "WanPolicy")
    val wanPolicy: Int? = 0

    @XmlElement(name = "maxsignal")
    val maxSignal: Int? = 0

    @XmlElement(name = "wifiindooronly")
    val wifiIndoorOnly: Int? = 0

    @XmlElement(name = "wififrequence")
    val wifiFrequence: Int? = 0

    @XmlElement(name = "classify")
    val classify: String? = null

    @XmlElement(name = "flymode")
    val flightmode: Int? = 0

    @XmlElement(name = "cellroam")
    val cellroam: Int? = 0

    @XmlElement(name = "usbup")
    val usbup: Int? = 0
}

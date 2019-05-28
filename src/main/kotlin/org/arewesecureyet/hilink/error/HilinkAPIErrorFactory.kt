package org.arewesecureyet.hilink.error

import org.arewesecureyet.hilink.Hilink

class HilinkAPIErrorFactory {
    companion object {
        @JvmStatic
        fun getHilinkAPIError(code: Int): HilinkAPIError {
            return when(code) {
                -1 -> HilinkAPIError(code, "System not available")
                100002 -> HilinkAPIError(code, "not supported by firmware or(code, incorrect API path")
                100003 -> HilinkAPIUnauthorizedError(code, "unauthorized")
                100004 -> HilinkAPIBusyError(code, "system busy")
                100005 -> HilinkAPIError(code, "unknown error")
                100006 -> HilinkAPIError(code, "invalid parameter")
                100009 -> HilinkAPIError(code, "write error")
                103002 -> HilinkAPIError(code, "unknown error")
                103015 -> HilinkAPIError(code, "unknown error")
                108001 -> HilinkAPIUnauthorizedError(code, "invalid username")
                108002 -> HilinkAPIUnauthorizedError(code, "invalid password")
                108003 -> HilinkAPIError(code, "user(code, already logged in")
                108006 -> HilinkAPIUnauthorizedError(code, "invalid username or(code, password")
                108007 -> HilinkAPIUnauthorizedError(code, "invalid username password, or(code, session timeout")
                110024 -> HilinkAPIError(code, "battery charge less than 50%")
                111019 -> HilinkAPINetworkError(code, "no network response")
                111020 -> HilinkAPINetworkError(code, "network timeout")
                111022 -> HilinkAPINetworkError(code, "network not supported")
                113018 -> HilinkAPIBusyError(code, "system busy")
                114001 -> HilinkAPIError(code, "file already exists")
                114002 -> HilinkAPIError(code, "file already exists")
                114003 -> HilinkAPIBusyError(code, "SD card currently in use")
                114004 -> HilinkAPIError(code, "path does not exist")
                114005 -> HilinkAPIError(code, "path too long")
                114006 -> HilinkAPIUnauthorizedError(code, "no permission for(code, specified file or(code, directory")
                115001 -> HilinkAPIError(code, "unknown error")
                117001 -> HilinkAPIError(code, "incorrect WiFi password")
                117004 -> HilinkAPIError(code, "incorrect WISPr(code, password")
                120001 -> HilinkAPIBusyError(code, "voice busy")
                125001 -> HilinkAPIError(code, "invalid token")
                else -> HilinkAPIError(code, "Unknown")
            }
        }
    }
}
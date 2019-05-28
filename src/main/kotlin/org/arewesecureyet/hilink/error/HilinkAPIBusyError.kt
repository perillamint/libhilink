package org.arewesecureyet.hilink.error

class HilinkAPIBusyError: HilinkAPIError {
    constructor(code: Int, msg: String): super(code, msg)
}
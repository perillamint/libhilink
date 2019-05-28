package org.arewesecureyet.hilink.error

class HilinkAPINetworkError: HilinkAPIError {
    constructor(code: Int, msg: String): super(code, msg)
}

package org.arewesecureyet.hilink.error

class HilinkAPIUnauthorizedError: HilinkAPIError {
    constructor(code: Int, msg: String): super(code, msg)
}
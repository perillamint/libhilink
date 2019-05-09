package org.arewesecureyet.hilink.error

class HilinkAPIError: HilinkError {
    val code: Int

    constructor(code: Int, msg: String): super("Error $code - $msg") {
        this.code = code
    }
}
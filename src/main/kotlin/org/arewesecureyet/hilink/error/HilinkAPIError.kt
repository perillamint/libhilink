package org.arewesecureyet.hilink.error

open class HilinkAPIError: HilinkError {
    val code: Int

    constructor(code: Int, msg: String): super("Error $code - $msg") {
        this.code = code
    }
}
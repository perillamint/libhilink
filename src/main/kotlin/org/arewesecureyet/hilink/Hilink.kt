package org.arewesecureyet.hilink

import java.time.Duration
import kotlin.properties.Delegates

class Hilink {
    var baseUrl: String
    var hilinkSession: HilinkSession

    constructor(baseUrl: String) {
        this.baseUrl = baseUrl;
        this.hilinkSession = HilinkSession(baseUrl, Duration.ofMillis(500))
    }
}
package org.arewesecureyet.hilink

import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl

class HilinkCookieJar: CookieJar{
    private var cookies: MutableList<Cookie>? = null;

    override fun saveFromResponse(url: HttpUrl, cookies: MutableList<Cookie>) {
        this.cookies = cookies;
    }

    override fun loadForRequest(url: HttpUrl): MutableList<Cookie> {
        return cookies?: ArrayList<Cookie>();
    }
}
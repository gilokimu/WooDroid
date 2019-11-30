package me.gilo.woodroid.data

import org.apache.http.NameValuePair

import java.util.ArrayList

class RestAdapter(private val baseUrl: String, private val consumerKey: String, private val consumerSecret: String) {
    companion object {

        internal var oauth_nonce = ""
        internal var oauth_timestamp = ""
        internal var oauth_signature_method = "HMAC-SHA1"

        internal var params: ArrayList<NameValuePair>? = null
    }


}

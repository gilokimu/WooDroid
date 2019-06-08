package me.gilo.woodroid.data.auth

import android.util.Base64
import android.util.Log
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import org.apache.http.NameValuePair
import org.apache.http.client.utils.URLEncodedUtils
import org.apache.http.message.BasicNameValuePair

import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec
import java.io.IOException
import java.io.UnsupportedEncodingException
import java.net.URLDecoder
import java.net.URLEncoder
import java.security.InvalidKeyException
import java.security.NoSuchAlgorithmException
import java.util.*
import java.util.Map

class AuthIntercepter(private val consumerKey: String, private val consumerSecret: String) : Interceptor {
    private var oauth_signature = ""


    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val params = getOauthParams(chain)

        val builder = chain.request().url().newBuilder()
        for (entry in params) {
            builder.addQueryParameter(entry.name, entry.value)
        }

        val newRequest = chain.request()
            .newBuilder()
            .url(builder.build())
            .header("Accept", "application/json")
            .build()

        return chain.proceed(newRequest)
    }

    fun getOauthParams(chain: Interceptor.Chain): ArrayList<NameValuePair> {
        val params = ArrayList<NameValuePair>()

        var request_url = chain.request().url().toString()

        val iterator = getQueryParams(request_url).entries.iterator()
        while (iterator.hasNext()) {
            val pair = iterator.next() as Map.Entry<*, *>

            val key = pair.key as String
            val values = pair.value as List<String>
            var value = ""

            //why there would be multiple values for single key is not so clear to me, will keep this here though
            if (values.size == 1) {
                value = values[0]
            }

            params.add(BasicNameValuePair(key, value))

            iterator.remove()
        }

        if (request_url.contains("?")) {
            val request_url_end = request_url.indexOf("?")
            request_url = request_url.substring(0, request_url_end)
        }

        oauth_nonce = getOauth_nonce()
        oauth_timestamp = getOauth_timestamp()

        params.add(BasicNameValuePair("oauth_consumer_key", consumerKey))
        params.add(BasicNameValuePair("oauth_nonce", oauth_nonce))
        params.add(BasicNameValuePair("oauth_timestamp", oauth_timestamp))
        params.add(BasicNameValuePair("oauth_signature_method", oauth_signature_method))

        Collections.sort(params, AlphabeticSorter())
        val encodedParams = URLEncodedUtils.format(params, "utf-8")
        oauth_signature = getOauth_signature(chain.request().method(), request_url, consumerSecret, encodedParams)

        params.add(BasicNameValuePair("oauth_signature", oauth_signature))

        return params
    }

    fun getOauth_nonce(): String {
        return StringBuilder((Math.random() * 100000000.0).toString()).toString()
    }

    fun getStringToSign(method: String, url: String, parameters: String): String {
        var string_to_sign = ""
        try {
            string_to_sign = StringBuilder("$method&")
                .append(URLEncoder.encode(url, "utf-8")).append("&")
                .append(URLEncoder.encode(parameters, "utf-8"))
                .toString()
        } catch (e: UnsupportedEncodingException) {
            e.printStackTrace()
        }

        return string_to_sign
    }


    fun getOauth_signature(method: String, url: String, consumerSecret: String, parameters: String): String {
        var signature = ""
        val string_to_sign = getStringToSign(method, url, parameters)

        try {
            val mac = Mac.getInstance(oauth_signature_method)
            val secret = "$consumerSecret&"
            mac.init(SecretKeySpec(secret.toByteArray(charset("utf-8")), oauth_signature_method))
            signature =
                Base64.encodeToString(mac.doFinal(string_to_sign.toByteArray(charset("utf-8"))), 0).trim { it <= ' ' }
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        } catch (e: InvalidKeyException) {
            e.printStackTrace()
        } catch (e: UnsupportedEncodingException) {
            e.printStackTrace()
        }

        return signature
    }


    fun getOauth_timestamp(): String {
        val stamp = (System.currentTimeMillis() / 1000.0).toLong()
        return StringBuilder(stamp.toString()).toString()
    }

    companion object {


        internal var oauth_nonce = ""
        internal var oauth_timestamp = ""
        internal var oauth_signature_method = "HMAC-SHA1"

        fun getQueryParams(url: String): MutableMap<String, List<String>> {
            try {
                val params = HashMap<String, List<String>>()
                val urlParts = url.split("\\?".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                if (urlParts.size > 1) {
                    val query = urlParts[1]
                    for (param in query.split("&".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
                        val pair = param.split("=".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                        val key = URLDecoder.decode(pair[0], "UTF-8")
                        var value = ""
                        if (pair.size > 1) {
                            value = URLDecoder.decode(pair[1], "UTF-8")
                        }

                        var values: MutableList<String>? = params[key]?.toMutableList()
                        if (values == null) {
                            values = ArrayList()
                            params[key] = values
                        }
                        values.add(value)
                    }
                }

                return params
            } catch (ex: UnsupportedEncodingException) {
                throw AssertionError(ex)
            }

        }
    }
}

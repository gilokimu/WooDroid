package me.gilo.woodroid.data.cookie

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

import java.io.IOException

class DemoCookieInterceptor : Interceptor {


    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()

        builder.addHeader(
            "Cookie",
            "wordpress_logged_in_9073cf57240df660c1e240d327cc46cb=gilo%7C1551794958%7CJx1NTnn0f6wuYlN5a0PmTJxYcPlr1sUUqpr659EKCcG%7C802c643a30a82bf7aa6350b5fb5dd005c019b2e1b1d59566ef0c426e33126eae"
        )
        builder.addHeader("Cookie", "woocommerce_cart_hash=d9ec6c9bf0d307629c2a981362735284")
        builder.addHeader(
            "Cookie",
            "wp_woocommerce_session_9073cf57240df660c1e240d327cc46cb=1%7C%7C1551796439%7C%7C1551792839%7C%7Ce6deec897575a9a84bb4a672abf2ed72"
        )



        return chain.proceed(builder.build())
    }
}
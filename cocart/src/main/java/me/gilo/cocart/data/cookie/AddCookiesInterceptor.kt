package me.gilo.woodroid.data.cookie

import android.content.Context
import android.preference.PreferenceManager
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

import java.io.IOException
import java.util.HashSet

class AddCookiesInterceptor(private val context: Context) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()

        val preferences = PreferenceManager.getDefaultSharedPreferences(context).getStringSet(
            PREF_COOKIES,
            HashSet()
        ) as HashSet<String>
        for (cookie in preferences) {
            builder.addHeader("Cookie", cookie)
        }

        return chain.proceed(builder.build())
    }

    companion object {

        val PREF_COOKIES = "PREF_COOKIES"
    }
}
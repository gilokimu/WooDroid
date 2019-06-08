package me.gilo.woodroid.repo

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import me.gilo.woodroid.data.auth.AuthIntercepter
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import java.util.concurrent.TimeUnit

open class WooRepository(baseUrl: String, consumerKey: String, consumerSecret: String) {

    //TODO ('Apply DI or single instance on this')
    var retrofit: Retrofit

    init {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val gson = GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            .create()


        val client = OkHttpClient.Builder()
            .addInterceptor(AuthIntercepter(consumerKey, consumerSecret))
            .addInterceptor(loggingInterceptor)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
    }


}

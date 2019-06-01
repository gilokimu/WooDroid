package me.gilo.woodroid.repo

import android.content.Context
import me.gilo.woodroid.data.api.CartAPI
import me.gilo.woodroid.data.cookie.AddCookiesInterceptor
import me.gilo.woodroid.data.cookie.ReceivedCookiesInterceptor
import me.gilo.woodroid.models.LineItem
import me.gilo.woodroid.models.filters.CartFilter
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.Call
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class CartRepository(internal var baseUrl: String, consumerKey: String, consumerSecret: String) {

    internal var apiService: CartAPI
    internal var retrofit: Retrofit

    init {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY


        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        apiService = retrofit.create(CartAPI::class.java)
    }

    fun turnOnCookies(context: Context) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(AddCookiesInterceptor(context))
            .addInterceptor(ReceivedCookiesInterceptor(context))
            .addInterceptor(loggingInterceptor)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        apiService = retrofit.create(CartAPI::class.java)
    }

    fun clear(): Call<String> {
        return apiService.clear()
    }


    fun count(id: Int): Call<Int> {
        return apiService.count()
    }

    fun cart(): Call<Map<String, LineItem>> {
        return apiService.list()
    }

    fun addToCart(lineItem: LineItem): Call<Map<String, LineItem>> {
        return apiService.addToCart(lineItem)
    }

    fun delete(cardId: String): Call<String> {
        val cartFilter = CartFilter(cardId)
        return apiService.delete(cartFilter)
    }

    fun restore(cardId: String): Call<String> {
        val cartFilter = CartFilter(cardId)
        return apiService.restore(cartFilter)
    }

    fun update(cardId: String, quantity: Int): Call<String> {
        val cartFilter = CartFilter(cardId)
        cartFilter.quantity = quantity

        return apiService.update(cartFilter)
    }


}

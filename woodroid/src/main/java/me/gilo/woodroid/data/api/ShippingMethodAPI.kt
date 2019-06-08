package me.gilo.woodroid.data.api


import retrofit2.Call
import me.gilo.woodroid.models.ShippingMethod
import retrofit2.http.GET
import retrofit2.http.Path

interface ShippingMethodAPI {

    @GET("shipping_methods/{id}")
    fun view(@Path("id") id: String): Call<ShippingMethod>

    @GET("shipping_methods")
    fun list(): Call<List<ShippingMethod>>

}
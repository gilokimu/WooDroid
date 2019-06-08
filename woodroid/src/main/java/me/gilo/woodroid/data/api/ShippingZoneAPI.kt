package me.gilo.woodroid.data.api


import me.gilo.woodroid.models.ShippingZone
import retrofit2.Call
import retrofit2.http.*

import java.util.ArrayList

interface ShippingZoneAPI {

    @Headers("Content-Type: application/json")
    @POST("shipping/zones")
    fun create(@Body body: ShippingZone): Call<ShippingZone>

    @GET("shipping/zones/{id}")
    fun view(@Path("id") id: Int): Call<ShippingZone>

    @GET("shipping/zones")
    fun list(): Call<List<ShippingZone>>

    @Headers("Content-Type: application/json")
    @PUT("shipping/zones/{id}")
    fun update(@Path("id") id: Int, @Body body: ShippingZone): Call<ShippingZone>

    @DELETE("shipping/zones/{id}")
    fun delete(@Path("id") id: Int): Call<ShippingZone>

    @DELETE("shipping/zones/{id}")
    fun delete(@Path("id") id: Int, @Query("force") force: Boolean): Call<ShippingZone>

    @POST("shipping/zones/batch")
    fun batch(@Body body: ShippingZone): Call<String>

    @GET("coupons")
    fun filter(@QueryMap filter: Map<String, String>): Call<ArrayList<ShippingZone>>

}
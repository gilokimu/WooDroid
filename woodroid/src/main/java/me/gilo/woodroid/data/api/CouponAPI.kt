package me.gilo.woodroid.data.api


import me.gilo.woodroid.models.Coupon
import retrofit2.Call
import retrofit2.http.*

interface CouponAPI {

    @Headers("Content-Type: application/json")
    @POST("coupons")
    fun create(@Body body: Coupon): Call<Coupon>

    @GET("coupons/{id}")
    fun view(@Path("id") id: Int): Call<Coupon>

    @GET("coupons")
    fun list(): Call<List<Coupon>>

    @GET("coupons")
    fun filter(@QueryMap filter: Map<String, String>): Call<List<Coupon>>

    @Headers("Content-Type: application/json")
    @PUT("coupons/{id}")
    fun update(@Path("id") id: Int, @Body body: Coupon): Call<Coupon>

    @DELETE("coupons/{id}")
    fun delete(@Path("id") id: Int): Call<Coupon>

    @DELETE("coupons/{id}")
    fun delete(@Path("id") id: Int, @Query("force") force: Boolean): Call<Coupon>

    @POST("coupons/batch")
    fun batch(@Body body: Coupon): Call<String>

}
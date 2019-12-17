package me.gilo.cocart.data.api


import me.gilo.cocart.data.requests.CartItemRequest
import me.gilo.cocart.data.requests.CartRequest
import me.gilo.cocart.model.CartItem
import me.gilo.cocart.model.CartTotal
import retrofit2.Call
import retrofit2.http.*

interface ItemsAPI {

    @Headers("Content-Type: application/json")
    @POST("add-item")
    fun addToCart(@Body body: CartItemRequest): Call<CartItem>

    @Headers("Content-Type: application/json")
    @GET("get-cart")
    fun list( @Query("thumb") thumb: Boolean = true): Call<Map<String, CartItem>>

    @POST("get-cart/saved")
    fun getCustomerCart(@Body body: CartRequest): Call<Map<String, CartItem>>

    @Headers("Content-Type: application/json")
    @POST("clear")
    fun clear(): Call<String>

    @Headers("Content-Type: application/json")
    @GET("count-items")
    fun count(): Call<Int>

    @Headers("Content-Type: application/json")
    @POST("calculate")
    fun calculate(@Query("return") returnTotal: Boolean = true): Call<String>

    @Headers("Content-Type: application/json")
    @GET("totals")
    fun totals(@Query("html") returnTotal: Boolean = true): Call<CartTotal>

}
package me.gilo.cocart.data.api


import me.gilo.cocart.data.requests.CartItemRequest
import me.gilo.cocart.model.CartItem
import retrofit2.Call
import retrofit2.http.*

interface ItemsAPI {

    @Headers("Content-Type: application/json")
    @POST("add-item")
    fun addToCart(@Body body: CartItemRequest): Call<Map<String, CartItem>>

}
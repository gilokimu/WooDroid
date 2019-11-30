package me.gilo.cocart.data.api


import retrofit2.Call
import retrofit2.http.*

interface FiltersAPI {

    @Headers("Content-Type: application/json")
    @POST("clear")
    fun clear(): Call<String>

    @GET("count-items")
    fun count(): Call<Int>


}
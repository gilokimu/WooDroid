package me.gilo.woodroid.data.api


import me.gilo.woodroid.models.Attribute
import retrofit2.Call
import retrofit2.http.*

interface ProductAttributeAPI {

    @Headers("Content-Type: application/json")
    @POST("products/attributes")
    fun create(@Body body: Attribute): Call<Attribute>

    @GET("products/attributes/{id}")
    fun view(@Path("id") id: Int): Call<Attribute>

    @GET("products/attributes")
    fun list(): Call<List<Attribute>>

    @Headers("Content-Type: application/json")
    @PUT("products/attributes/{id}")
    fun update(@Path("id") id: Int, @Body body: Attribute): Call<Attribute>

    @DELETE("products/attributes/{id}")
    fun delete(@Path("id") id: Int): Call<Attribute>

    @DELETE("products/attributes/{id}")
    fun delete(@Path("id") id: Int, @Query("force") force: Boolean): Call<Attribute>

    @POST("products/attributes/batch")
    fun batch(@Body body: Attribute): Call<String>

    @GET("products/attributes")
    fun filter(@QueryMap filter: Map<String, String>): Call<List<Attribute>>

}
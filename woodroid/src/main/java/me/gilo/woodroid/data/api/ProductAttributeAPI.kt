package me.gilo.woodroid.data.api


import me.gilo.woodroid.models.ProductAttribute
import retrofit2.Call
import retrofit2.http.*

interface ProductAttributeAPI {

    @Headers("Content-Type: application/json")
    @POST("products/productAttributes")
    fun create(@Body body: ProductAttribute): Call<ProductAttribute>

    @GET("products/productAttributes/{id}")
    fun view(@Path("id") id: Int): Call<ProductAttribute>

    @GET("products/productAttributes")
    fun list(): Call<List<ProductAttribute>>

    @Headers("Content-Type: application/json")
    @PUT("products/productAttributes/{id}")
    fun update(@Path("id") id: Int, @Body body: ProductAttribute): Call<ProductAttribute>

    @DELETE("products/productAttributes/{id}")
    fun delete(@Path("id") id: Int): Call<ProductAttribute>

    @DELETE("products/productAttributes/{id}")
    fun delete(@Path("id") id: Int, @Query("force") force: Boolean): Call<ProductAttribute>

    @POST("products/productAttributes/batch")
    fun batch(@Body body: ProductAttribute): Call<String>

    @GET("products/productAttributes")
    fun filter(@QueryMap filter: Map<String, String>): Call<List<ProductAttribute>>

}
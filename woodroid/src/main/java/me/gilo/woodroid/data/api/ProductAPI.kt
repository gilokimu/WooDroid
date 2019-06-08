package me.gilo.woodroid.data.api


import me.gilo.woodroid.models.Product
import retrofit2.Call
import retrofit2.http.*

import java.util.ArrayList

interface ProductAPI {


    @get:GET("products")
    val products: Call<ArrayList<Product>>

    @get:GET("products/count")
    val productsCount: Call<List<Product>>

    @GET("products/{id}")
    fun getProduct(@Path("id") id: Int): Call<Product>

    @GET("products")
    fun getProducts(@Query("filter[category]") category: String): Call<ArrayList<Product>>

    @GET("products")
    fun search(@Query("search") search: String): Call<ArrayList<Product>>

    @GET("products")
    fun filter(@QueryMap filter: Map<String, String>): Call<List<Product>>


    @Headers("Content-Type: application/json")
    @POST("products")
    fun create(@Body body: Product): Call<Product>

    @GET("products/{id}")
    fun view(@Path("id") id: Int): Call<Product>

    @GET("products")
    fun list(): Call<List<Product>>

    @Headers("Content-Type: application/json")
    @PUT("products/{id}")
    fun update(@Path("id") id: Int, @Body body: Product): Call<Product>

    @DELETE("products/{id}")
    fun delete(@Path("id") id: Int): Call<Product>

    @DELETE("products/{id}")
    fun delete(@Path("id") id: Int, @Query("force") force: Boolean): Call<Product>

    @POST("products/batch")
    fun batch(@Body body: Product): Call<String>

}
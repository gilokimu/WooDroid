package me.gilo.woodroid.data.api


import me.gilo.woodroid.models.Product
import me.gilo.woodroid.models.Variation
import retrofit2.Call
import retrofit2.http.*

interface ProductVariationAPI {

    @Headers("Content-Type: application/json")
    @POST("products/{id}/variations")
    fun create(@Path("id") product_id: Int, @Body body: Variation): Call<Variation>

    @GET("products/{id}/variations/{variation_id}")
    fun view(@Path("id") product_id: Int, @Path("variation_id") variation_id: Int): Call<Variation>

    @GET("products/{id}/variations")
    fun list(@Path("id") product_id: Int): Call<List<Variation>>

    @Headers("Content-Type: application/json")
    @PUT("products/{id}/variations/{variation_id}")
    fun update(@Path("id") product_id: Int, @Path("variation_id") variation_id: Int, @Body body: Variation): Call<Variation>

    @DELETE("products/{id}/variations/{variation_id}")
    fun delete(@Path("id") product_id: Int, @Path("variation_id") variation_id: Int): Call<Variation>

    @DELETE("products/{id}/variations/{variation_id}")
    fun delete(@Path("id") product_id: Int, @Path("variation_id") variation_id: Int, @Query("force") force: Boolean): Call<Variation>

    @Headers("Content-Type: application/json")
    @PUT("products/{id}/variations/{variation_id}")
    fun batch(@Path("id") product_id: Int, @Path("variation_id") variation_id: Int, @Body body: Product): Call<Variation>

    @GET("products/{id}/variations")
    fun filter(@Path("id") product_id: Int, @QueryMap filter: Map<String, String>): Call<List<Variation>>

}
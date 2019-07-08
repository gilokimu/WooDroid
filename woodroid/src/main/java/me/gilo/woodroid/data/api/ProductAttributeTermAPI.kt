package me.gilo.woodroid.data.api


import me.gilo.woodroid.models.AttributeTerm
import retrofit2.Call
import retrofit2.http.*

interface ProductAttributeTermAPI {

    @Headers("Content-Type: application/json")
    @POST("products/productAttributes/{id}/terms")
    fun create(@Path("id") attribute_id: Int, @Body body: AttributeTerm): Call<AttributeTerm>

    @GET("products/productAttributes/{id}/terms/[term_id]")
    fun view(@Path("id") attribute_id: Int, @Path("term_id") term_id: Int): Call<AttributeTerm>

    @GET("products/productAttributes/{id}/terms")
    fun list(@Path("id") attribute_id: Int): Call<List<AttributeTerm>>

    @Headers("Content-Type: application/json")
    @PUT("products/productAttributes/{id}/terms/[term_id]")
    fun update(@Path("id") attribute_id: Int, @Path("term_id") term_id: Int, @Body body: AttributeTerm): Call<AttributeTerm>

    @DELETE("products/productAttributes/{id}/terms/[term_id]")
    fun delete(@Path("id") attribute_id: Int, @Path("term_id") term_id: Int): Call<AttributeTerm>

    @DELETE("products/productAttributes/{id}/terms/[term_id]")
    fun delete(@Path("id") attribute_id: Int, @Path("term_id") term_id: Int, @Query("force") force: Boolean): Call<AttributeTerm>

    @POST("products/productAttributes/batch")
    fun batch(@Body body: AttributeTerm): Call<String>

    @GET("products/productAttributes/{id}/terms")
    fun filter(@Path("id") attribute_id: Int, @QueryMap filter: Map<String, String>): Call<List<AttributeTerm>>

}
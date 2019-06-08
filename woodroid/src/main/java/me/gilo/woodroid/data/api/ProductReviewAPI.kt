package me.gilo.woodroid.data.api


import me.gilo.woodroid.models.ProductReview
import retrofit2.Call
import retrofit2.http.*

interface ProductReviewAPI {

    @Headers("Content-Type: application/json")
    @POST("products/reviews")
    fun create(@Body body: ProductReview): Call<ProductReview>

    @GET("products/reviews/{id}")
    fun view(@Path("id") id: Int): Call<ProductReview>

    @GET("products/reviews")
    fun list(): Call<List<ProductReview>>

    @Headers("Content-Type: application/json")
    @PUT("products/reviews/{id}")
    fun update(@Path("id") id: Int, @Body body: ProductReview): Call<ProductReview>

    @DELETE("products/reviews/{id}")
    fun delete(@Path("id") id: Int): Call<ProductReview>

    @DELETE("products/reviews/{id}")
    fun delete(@Path("id") id: Int, @Query("force") force: Boolean): Call<ProductReview>

    @POST("products/reviews/batch")
    fun batch(@Body body: ProductReview): Call<String>

    @GET("products/reviews")
    fun filter(@QueryMap filter: Map<String, String>): Call<List<ProductReview>>

}
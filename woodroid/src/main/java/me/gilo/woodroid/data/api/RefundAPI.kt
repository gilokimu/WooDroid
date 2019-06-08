package me.gilo.woodroid.data.api


import me.gilo.woodroid.models.Refund
import retrofit2.Call
import retrofit2.http.*

interface RefundAPI {

    @Headers("Content-Type: application/json")
    @POST("orders/{id}/refunds")
    fun create(@Path("id") order_id: Int, @Body body: Refund): Call<Refund>

    @GET("orders/{id}/refunds/{refund_id}")
    fun view(@Path("id") order_id: Int, @Path("refund_id") refund_id: Int): Call<Refund>

    @GET("orders/{id}/refunds")
    fun list(@Path("id") order_id: Int): Call<List<Refund>>

    @DELETE("orders/{id}/refunds/{refund_id}")
    fun delete(@Path("id") order_id: Int, @Path("refund_id") refund_id: Int): Call<Refund>

    @DELETE("orders/{id}/refunds/{refund_id}")
    fun delete(@Path("id") order_id: Int, @Path("refund_id") refund_id: Int, @Query("force") force: Boolean): Call<Refund>

    @GET("orders/{id}/refunds")
    fun filter(@Path("id") order_id: Int, @QueryMap filter: Map<String, String>): Call<List<Refund>>

}
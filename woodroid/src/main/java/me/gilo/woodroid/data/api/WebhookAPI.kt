package me.gilo.woodroid.data.api


import me.gilo.woodroid.models.Webhook
import me.gilo.woodroid.models.WebhookDelivery
import retrofit2.Call
import retrofit2.http.*

import java.util.ArrayList

interface WebhookAPI {

    @Headers("Content-Type: application/json")
    @POST("webhooks")
    fun create(@Body body: Webhook): Call<Webhook>

    @GET("webhooks")
    fun list(): Call<List<Webhook>>

    @GET("webhooks/{id}")
    fun view(@Path("id") id: Int): Call<Webhook>

    @GET("webhooks/{id}/deliveries/{delivery_id}")
    fun delivery(@Path("id") webhook_id: Int, @Path("delivery_id") delivery_id: Int): Call<WebhookDelivery>

    @GET("webhooks/{id}/deliveries")
    fun deliveries(@Path("id") webhook_id: Int): Call<List<WebhookDelivery>>

    @Headers("Content-Type: application/json")
    @PUT("webhooks/{id}")
    fun update(@Path("id") id: Int, @Body body: Webhook): Call<Webhook>

    @DELETE("webhooks/{id}")
    fun delete(@Path("id") id: Int): Call<Webhook>

    @DELETE("webhooks/{id}")
    fun delete(@Path("id") id: Int, @Query("force") force: Boolean): Call<Webhook>

    @GET("webhooks")
    fun filter(@QueryMap filter: Map<String, String>): Call<ArrayList<Webhook>>

}
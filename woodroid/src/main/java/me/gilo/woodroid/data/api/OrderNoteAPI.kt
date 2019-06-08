package me.gilo.woodroid.data.api


import me.gilo.woodroid.models.OrderNote
import retrofit2.Call
import retrofit2.http.*

interface OrderNoteAPI {

    @Headers("Content-Type: application/json")
    @POST("orders/{id}/notes")
    fun create(@Path("id") order_id: Int, @Body body: OrderNote): Call<OrderNote>

    @GET("orders/{id}/notes/{note_id}")
    fun view(@Path("id") order_id: Int, @Path("note_id") note_id: Int): Call<OrderNote>

    @GET("orders/{id}/notes")
    fun list(@Path("id") order_id: Int): Call<List<OrderNote>>

    @DELETE("orders/{id}/notes/{note_id}")
    fun delete(@Path("id") order_id: Int, @Path("note_id") note_id: Int): Call<OrderNote>

    @DELETE("orders/{id}/notes/{note_id}")
    fun delete(@Path("id") order_id: Int, @Path("note_id") note_id: Int, @Query("force") force: Boolean): Call<OrderNote>

    @GET("orders/{id}/notes")
    fun filter(@Path("id") order_id: Int, @QueryMap filter: Map<String, String>): Call<List<OrderNote>>

}
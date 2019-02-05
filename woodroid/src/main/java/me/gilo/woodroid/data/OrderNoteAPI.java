package me.gilo.woodroid.data;


import me.gilo.woodroid.models.Coupon;
import me.gilo.woodroid.models.Order;
import me.gilo.woodroid.models.OrderNote;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface OrderNoteAPI {

    @Headers("Content-Type: application/json")
    @POST("orders/{id}/notes")
    Call<OrderNote> create(@Body Coupon body);

    @GET("orders/{id}/notes/{note_id}")
    Call<OrderNote> view(@Path("id") int order_id, @Path("note_id") int note_id);

    @GET("orders/{id}/notes")
    Call<List<OrderNote>> list(@Path("id") int order_id);

    @DELETE("orders/{id}/notes/{note_id}")
    Call<OrderNote> delete(@Path("id") int order_id, @Path("note_id") int note_id);

    @DELETE("orders/{id}/notes/{note_id}")
    Call<OrderNote> delete(@Path("id") int order_id, @Path("note_id") int note_id, @Query("force") boolean force);

}
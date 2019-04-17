package me.gilo.woodroid.data.api;


import me.gilo.woodroid.models.Webhook;
import me.gilo.woodroid.models.WebhookDelivery;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface WebhookAPI {

    @Headers("Content-Type: application/json")
    @POST("webhooks")
    Call<Webhook> create(@Body Webhook body);

    @GET("webhooks")
    Call<List<Webhook>> list();

    @GET("webhooks/{id}")
    Call<Webhook> view(@Path("id") int id);

    @GET("webhooks/{id}/deliveries/{delivery_id}")
    Call<WebhookDelivery> delivery(@Path("id") int webhook_id, @Path("delivery_id") int delivery_id);

    @GET("webhooks/{id}/deliveries")
    Call<List<WebhookDelivery>> deliveries(@Path("id") int webhook_id);

    @Headers("Content-Type: application/json")
    @PUT("webhooks/{id}")
    Call<Webhook> update(@Path("id") int id, @Body Webhook body);

    @DELETE("webhooks/{id}")
    Call<Webhook> delete(@Path("id") int id);

    @DELETE("webhooks/{id}")
    Call<Webhook> delete(@Path("id") int id, @Query("force") boolean force);

    @GET("webhooks")
    Call<ArrayList<Webhook>> filter(@QueryMap Map<String, String> filter);

}
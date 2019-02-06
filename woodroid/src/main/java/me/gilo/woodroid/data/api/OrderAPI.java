package me.gilo.woodroid.data.api;


import me.gilo.woodroid.models.Coupon;
import me.gilo.woodroid.models.Order;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface OrderAPI {

    @Headers("Content-Type: application/json")
    @POST("orders")
    Call<Order> create(@Body Order body);

    @GET("orders/{id}")
    Call<Order> view(@Path("id") int id);

    @GET("orders")
    Call<List<Order>> list();

    @Headers("Content-Type: application/json")
    @PUT("orders/{id}")
    Call<Order> update(@Path("id") int id, @Body Order body);

    @DELETE("orders/{id}")
    Call<Order> delete(@Path("id") int id);

    @DELETE("orders/{id}")
    Call<Order> delete(@Path("id") int id, @Query("force") boolean force);

    @POST("orders/batch")
    Call<String> batch(@Body Order body);

    @GET("coupons")
    Call<ArrayList<Order>> filter(@QueryMap Map<String, String> filter);

}
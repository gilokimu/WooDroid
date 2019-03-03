package me.gilo.woodroid.data.api;


import me.gilo.woodroid.models.Coupon;
import me.gilo.woodroid.models.LineItem;
import me.gilo.woodroid.models.filters.CartFilter;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

public interface CartAPI {

    @Headers("Content-Type: application/json")
    @POST("clear")
    Call<String> clear();

    @GET("count-items")
    Call<Integer> count();

    @GET("cart")
    Call<Map<String, LineItem>> list();

    @Headers("Content-Type: application/json")
    @POST("cart/add")
    Call<Map<String, LineItem>> addToCart(@Body LineItem body);

    @DELETE("cart/cart-item")
    Call<String> delete(@Body CartFilter body);

    @GET("cart/cart-item")
    Call<String> restore(@Body CartFilter body);

    @Headers("Content-Type: application/json")
    @POST("cart/cart-item")
    Call<String> update(@Body CartFilter body);


}
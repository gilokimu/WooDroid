package me.gilo.woodroid.data.api;


import me.gilo.woodroid.models.Coupon;
import me.gilo.woodroid.models.ShippingClass;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface ShippingClassAPI {

    @Headers("Content-Type: application/json")
    @POST("products/shipping_classes")
    Call<ShippingClass> create(@Body ShippingClass body);

    @GET("products/shipping_classes/{id}")
    Call<ShippingClass> view(@Path("id") int id);

    @GET("products/shipping_classes")
    Call<List<ShippingClass>> list();

    @Headers("Content-Type: application/json")
    @PUT("products/shipping_classes/{id}")
    Call<ShippingClass> update(@Path("id") int id, @Body ShippingClass body);

    @DELETE("products/shipping_classes/{id}")
    Call<ShippingClass> delete(@Path("id") int id);

    @DELETE("products/shipping_classes/{id}")
    Call<ShippingClass> delete(@Path("id") int id, @Query("force") boolean force);

    @POST("products/shipping_classes/batch")
    Call<String> batch(@Body ShippingClass body);

    @GET("coupons")
    Call<ArrayList<ShippingClass>> filter(@QueryMap Map<String, String> filter);

}
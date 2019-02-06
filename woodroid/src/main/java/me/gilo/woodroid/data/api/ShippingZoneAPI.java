package me.gilo.woodroid.data.api;


import me.gilo.woodroid.models.Coupon;
import me.gilo.woodroid.models.ShippingZone;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface ShippingZoneAPI {

    @Headers("Content-Type: application/json")
    @POST("shipping/zones")
    Call<ShippingZone> create(@Body ShippingZone body);

    @GET("shipping/zones/{id}")
    Call<ShippingZone> view(@Path("id") int id);

    @GET("shipping/zones")
    Call<List<ShippingZone>> list();

    @Headers("Content-Type: application/json")
    @PUT("shipping/zones/{id}")
    Call<ShippingZone> update(@Path("id") int id, @Body ShippingZone body);

    @DELETE("shipping/zones/{id}")
    Call<ShippingZone> delete(@Path("id") int id);

    @DELETE("shipping/zones/{id}")
    Call<ShippingZone> delete(@Path("id") int id, @Query("force") boolean force);

    @POST("shipping/zones/batch")
    Call<String> batch(@Body ShippingZone body);

    @GET("coupons")
    Call<ArrayList<ShippingZone>> filter(@QueryMap Map<String, String> filter);

}
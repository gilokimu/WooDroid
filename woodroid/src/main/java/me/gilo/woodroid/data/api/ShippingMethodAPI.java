package me.gilo.woodroid.data.api;


import me.gilo.woodroid.callback.WooCall;
import me.gilo.woodroid.models.Coupon;
import me.gilo.woodroid.models.ShippingMethod;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

public interface ShippingMethodAPI {

    @GET("shipping_methods/{id}")
    WooCall<ShippingMethod> view(@Path("id") String id);

    @GET("shipping_methods")
    WooCall<List<ShippingMethod>> list();

}
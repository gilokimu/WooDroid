package me.gilo.woodroid.data.api;


import retrofit2.Call;
import me.gilo.woodroid.models.ShippingMethod;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface ShippingMethodAPI {

    @GET("shipping_methods/{id}")
    Call<ShippingMethod> view(@Path("id") String id);

    @GET("shipping_methods")
    Call<List<ShippingMethod>> list();

}
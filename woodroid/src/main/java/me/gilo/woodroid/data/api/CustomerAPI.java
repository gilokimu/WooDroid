package me.gilo.woodroid.data.api;


import me.gilo.woodroid.models.Coupon;
import me.gilo.woodroid.models.Customer;
import me.gilo.woodroid.models.Download;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface CustomerAPI {

    @Headers("Content-Type: application/json")
    @POST("customers")
    Call<Customer> create(@Body Customer body);

    @GET("customers/{id}")
    Call<Customer> view(@Path("id") int id);

    @GET("customers")
    Call<List<Customer>> list();

    @Headers("Content-Type: application/json")
    @PUT("customers/{id}")
    Call<Customer> update(@Path("id") int id, @Body Customer body);

    @DELETE("customers/{id}")
    Call<Customer> delete(@Path("id") int id);

    @DELETE("customers/{id}")
    Call<Customer> delete(@Path("id") int id, @Query("force") boolean force);

    @POST("customers/batch")
    Call<String> batch(@Body Customer body);

    @POST("customers/{id}/downloads")
    Call<List<Download>> downloads(@Path("id") int id);

    @GET("customers")
    Call<List<Customer>> filter(@QueryMap Map<String, String> filter);

}
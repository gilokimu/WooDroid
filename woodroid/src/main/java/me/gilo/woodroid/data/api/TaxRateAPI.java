package me.gilo.woodroid.data.api;


import me.gilo.woodroid.models.Coupon;
import me.gilo.woodroid.models.TaxRate;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface TaxRateAPI {

    @Headers("Content-Type: application/json")
    @POST("taxes")
    Call<TaxRate> create(@Body TaxRate body);

    @GET("taxes/{id}")
    Call<TaxRate> view(@Path("id") int id);

    @GET("taxes")
    Call<List<TaxRate>> list();

    @Headers("Content-Type: application/json")
    @PUT("taxes/{id}")
    Call<TaxRate> update(@Path("id") int id, @Body TaxRate body);

    @DELETE("taxes/{id}")
    Call<TaxRate> delete(@Path("id") int id);

    @DELETE("taxes/{id}")
    Call<TaxRate> delete(@Path("id") int id, @Query("force") boolean force);

    @POST("taxes/batch")
    Call<String> batch(@Body TaxRate body);

    @GET("coupons")
    Call<ArrayList<TaxRate>> filter(@QueryMap Map<String, String> filter);

}
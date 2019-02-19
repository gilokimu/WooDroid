package me.gilo.woodroid.data.api;


import me.gilo.woodroid.models.Coupon;
import me.gilo.woodroid.models.OrderNote;
import me.gilo.woodroid.models.Product;
import me.gilo.woodroid.models.Variation;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface ProductVariationAPI {

    @Headers("Content-Type: application/json")
    @POST("products/{id}/variations")
    Call<Variation> create(@Path("id") int product_id, @Body Variation body);

    @GET("products/{id}/variations/{variation_id}")
    Call<Variation> view(@Path("id") int product_id, @Path("variation_id") int variation_id);

    @GET("products/{id}/variations")
    Call<List<Variation>> list(@Path("id") int product_id);

    @Headers("Content-Type: application/json")
    @PUT("products/{id}/variations/{variation_id}")
    Call<Variation> update(@Path("id") int product_id, @Path("variation_id") int variation_id, @Body Variation body);

    @DELETE("products/{id}/variations/{variation_id}")
    Call<Variation> delete(@Path("id") int product_id, @Path("variation_id") int variation_id);

    @DELETE("products/{id}/variations/{variation_id}")
    Call<Variation> delete(@Path("id") int product_id, @Path("variation_id") int variation_id, @Query("force") boolean force);

    @Headers("Content-Type: application/json")
    @PUT("products/{id}/variations/{variation_id}")
    Call<Variation> batch(@Path("id") int product_id, @Path("variation_id") int variation_id, @Body Product body);

    @GET("products/{id}/variations")
    Call<List<Variation>> filter(@Path("id") int product_id, @QueryMap Map<String, String> filter);

}
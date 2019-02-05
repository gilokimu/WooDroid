package me.gilo.woodroid.data;


import me.gilo.woodroid.models.Coupon;
import me.gilo.woodroid.models.OrderNote;
import me.gilo.woodroid.models.Product;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface ProductVariationAPI {

    @Headers("Content-Type: application/json")
    @POST("products/{id}/variations")
    Call<Product> create(@Body Product body);

    @GET("products/{id}/variations/{variation_id}")
    Call<Product> view(@Path("id") int product_id, @Path("note_id") int note_id);

    @GET("products/{id}/variations")
    Call<List<Product>> list(@Path("id") int product);

    @Headers("Content-Type: application/json")
    @PUT("products/{id}/variations/{variation_id}")
    Call<Product> update(@Path("id") int product_id, @Path("variation_id") int variation_id, @Body Product body);

    @DELETE("products/{id}/variations/{variation_id}")
    Call<Product> delete(@Path("id") int product_id, @Path("variation_id") int variation_id);

    @DELETE("products/{id}/variations/{variation_id}")
    Call<Product> delete(@Path("id") int product_id, @Path("variation_id") int variation_id, @Query("force") boolean force);

    @Headers("Content-Type: application/json")
    @PUT("products/{id}/variations/{variation_id}")
    Call<Product> batch(@Path("id") int product_id, @Path("variation_id") int variation_id, @Body Product body);



}
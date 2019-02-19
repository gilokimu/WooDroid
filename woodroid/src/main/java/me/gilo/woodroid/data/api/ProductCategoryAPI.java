package me.gilo.woodroid.data.api;


import me.gilo.woodroid.models.Category;
import me.gilo.woodroid.models.Coupon;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface ProductCategoryAPI {

    @Headers("Content-Type: application/json")
    @POST("products/categories")
    Call<Category> create(@Body Category body);

    @GET("products/categories/{id}")
    Call<Category> view(@Path("id") int id);

    @GET("products/categories")
    Call<List<Category>> list();

    @Headers("Content-Type: application/json")
    @PUT("products/categories/{id}")
    Call<Category> update(@Path("id") int id, @Body Category body);

    @DELETE("products/categories/{id}")
    Call<Category> delete(@Path("id") int id);

    @DELETE("products/categories/{id}")
    Call<Category> delete(@Path("id") int id, @Query("force") boolean force);

    @POST("products/categories/batch")
    Call<String> batch(@Body Category body);

    @GET("products/categories")
    Call<List<Category>> filter(@QueryMap Map<String, String> filter);

}
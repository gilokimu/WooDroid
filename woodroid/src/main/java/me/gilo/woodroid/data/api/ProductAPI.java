package me.gilo.woodroid.data.api;


import me.gilo.woodroid.models.Product;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface ProductAPI {


    @GET("products")
    Call<ArrayList<Product>> getProducts();

    @GET("products/{id}")
    Call<Product> getProduct(@Path("id") int id);

    @GET("products")
    Call<ArrayList<Product>> getProducts(@Query("filter[category]") String category);

    @GET("products")
    Call<ArrayList<Product>> search(@Query("search") String search);

    @GET("products")
    Call<List<Product>> filter(@QueryMap Map<String, String> filter);

    @GET("products/count")
    Call<List<Product>> getProductsCount();


    @Headers("Content-Type: application/json")
    @POST("products")
    Call<Product> create(@Body Product body);

    @GET("products/{id}")
    Call<Product> view(@Path("id") int id);

    @GET("products")
    Call<List<Product>> list();

    @Headers("Content-Type: application/json")
    @PUT("products/{id}")
    Call<Product> update(@Path("id") int id, @Body Product body);

    @DELETE("products/{id}")
    Call<Product> delete(@Path("id") int id);

    @DELETE("products/{id}")
    Call<Product> delete(@Path("id") int id, @Query("force") boolean force);

    @POST("products/batch")
    Call<String> batch(@Body Product body);

}
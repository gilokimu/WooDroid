package me.gilo.woodroid.data.api;


import me.gilo.woodroid.data.callbacks.*;
import me.gilo.woodroid.data.callbacks.Data;
import me.gilo.woodroid.models.*;
import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

import java.util.ArrayList;
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
    Call<ArrayList<Product>> filter(@QueryMap Map<String, String> filter);

    @GET("products/count")
    Call<ArrayList<Product>> getProductsCount();

}
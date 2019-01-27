package me.gilo.woodroid.data;


import me.gilo.woodroid.data.callbacks.*;
import me.gilo.woodroid.data.callbacks.Data;
import me.gilo.woodroid.models.*;
import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

import java.util.ArrayList;
import java.util.Map;

public interface ProductAPI {


    @GET("products/categories")
    Call<ArrayList<Category>> getCategories();

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

    @GET("products/{id}")
    Call<ProductCallback> getRelatedProducts(@Path("id") int id);


    @GET("products/count")
    Call<ArrayList<Product>> getProductsCount();

    @GET("products/{id}/reviews")
    Call<ReviewsCallback> getProductReviews(@Path("id") int id);

    @GET("products/{id}/orders")
    Call<ReviewsCallback> getProductOrders(@Path("id") int id);




    /*
    /products
    /products/count
    /products/<id>
    /products/<id>/reviews
    /products/<id>/orders
    /products/categories
    /products/categories/<id>
    /products/tags
    /products/tags/<id>
    /products/shipping_classes
    /products/shipping_classes/<id>
    /products/attributes
    /products/attributes/<id>
    /products/attributes/<attribute_id>/terms
    /products/attributes/<attribute_id>/terms/<id>
    /products/bulk
     */

}
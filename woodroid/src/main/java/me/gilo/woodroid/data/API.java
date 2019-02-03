package me.gilo.woodroid.data;


import me.gilo.woodroid.data.callbacks.*;
import me.gilo.woodroid.data.callbacks.Data;
import me.gilo.woodroid.models.*;
import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

import java.util.ArrayList;
import java.util.Map;

public interface API {

    @GET
    Observable<StoreCallback> store(@Url String url);

    ////////////////////////////////////////////////////////////////////////
    //products
    ////////////////////////////////////////////////////////////////////////
    @GET("products/categories")
    Call<ArrayList<Category>> getCategories();

    @GET
    Call<CategoriesCallback> getCategories2(@Url String url);

    @GET("products")
    Call<ArrayList<Product>> getProducts();

    @GET("products")
    Call<ArrayList<Product>> getProducts(@Query("filter[category]") String category);

    @GET("products")
    Call<ArrayList<Product>> search(@Query("search") String search);

    @GET
    Call<ReviewsCallback> getProductReviews(@Url String url);

    @GET("products")
    Call<ArrayList<Product>> filter(@QueryMap Map<String, String> filter);

    @GET("products/{id}")
    Call<ProductCallback> getRelatedProducts(@Path("id") int id);

    @GET("products/{id}")
    Call<Product> getProduct(@Path("id") int id);

    ////////////////////////////////////////////////////////////////////////
    //orders
    ////////////////////////////////////////////////////////////////////////
    @GET("orders")
    Observable<OrderCallback> getOrders();

    @Headers("Content-Type: application/json")
    @POST("orders")
    Call<OrderData> createOrder(@Body OrderData order);

    ////////////////////////////////////////////////////////////////////////
    //customer
    ////////////////////////////////////////////////////////////////////////
    @GET
    Observable<OrderCallback> viewMyOrders(@Url String url);

    @Headers("Content-Type: application/json")
    @POST("customers")
    Call<CustomerData> registerUser(@Body CustomerData body);

    @Headers("Content-Type: application/json")
    @POST("customers")
    Call<Data> registerUser2(@Body Data body);

    @GET
    Call<Customer> loginUser(@Url String url);

    @GET("customers/email/{email}")
    Call<Data> loginUser2(@Path("email") String email);

    ////////////////////////////////////////////////////////////////////////
    /** Coupons
        The coupons API allows you to
            1. create,
            2. view,
            3. update
            4. delete
        individual, or a batch, of coupon codes.

    **/
    ////////////////////////////////////////////////////////////////////////

    @Headers("Content-Type: application/json")
    @POST("coupons")
    Call<Coupon> createCoupon(@Body Coupon body);

    @GET("coupons/{id}")
    Call<Coupon> viewCoupon(@Path("id") int id);

    @GET("coupons/count")
    Call<Integer> viewCouponCount();

    @GET("coupons")
    Observable<Coupon> viewCouponList(@Path("id") int id);

    @PUT("coupons/{id}")
    Call<Coupon> updateCoupon(@Path("id") int id);

    @DELETE("coupons/{id}")
    Call<String> deleteCoupon(@Path("id") int id);

    ///////////////////////////////////////////////////////////////////////
    //Cart
    ////////////////////////////////////////////////////////////////////////





    /*


    /coupons
    /coupons/count
    /coupons/<id>
    /coupons/code/<code>
    /coupons/bulk
    /customers
    /customers/count
    /customers/<id>
    /customers/email/<email>
    /customers/<id>/orders
    /customers/<id>/downloads
    /customers/bulk
    /orders
    /orders/count
    /orders/statuses
    /orders/<id>
    /orders/<order_id>/notes
    /orders/<order_id>/notes/<id>
    /orders/<order_id>/refunds
    /orders/<order_id>/refunds/<id>
    /orders/bulk
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
    /reports
    /reports/sales
    /reports/sales/top_sellers
    /taxes
    /taxes/count
    /taxes/<id>
    /taxes/classes
    /taxes/classes/count
    /taxes/classes/<slug>
    /taxes/bulk
    /webhooks
    /webhooks/count
    /webhooks/<id>
    /webhooks/<webhook_id>/deliveries
    /webhooks/<webhook_id>/deliveries/<id>

     */

}
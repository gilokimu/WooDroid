package me.gilo.woodroid.data;


import me.gilo.woodroid.data.callbacks.ReviewsData;
import me.gilo.woodroid.models.Coupon;
import me.gilo.woodroid.models.ProductReview;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface ProductReviewAPI {

    @Headers("Content-Type: application/json")
    @POST("products/reviews")
    Call<ProductReview> create(@Body ProductReview body);

    @GET("products/reviews/{id}")
    Call<ProductReview> view(@Path("id") int id);

    @GET("products/reviews")
    Call<List<ProductReview>> list();

    @Headers("Content-Type: application/json")
    @PUT("products/reviews/{id}")
    Call<ProductReview> update(@Path("id") int id, @Body ProductReview body);

    @DELETE("products/reviews/{id}")
    Call<ProductReview> delete(@Path("id") int id);

    @DELETE("products/reviews/{id}")
    Call<ProductReview> delete(@Path("id") int id, @Query("force") boolean force);

    @POST("products/reviews/batch")
    Call<String> batch(@Body ProductReview body);

}
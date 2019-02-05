package me.gilo.woodroid.data;


import me.gilo.woodroid.models.Coupon;
import me.gilo.woodroid.models.Tag;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface TagAPI {

    @Headers("Content-Type: application/json")
    @POST("products/tags")
    Call<Tag> create(@Body Tag body);

    @GET("products/tags/{id}")
    Call<Tag> view(@Path("id") int id);

    @GET("products/tags")
    Call<List<Tag>> list();

    @Headers("Content-Type: application/json")
    @PUT("products/tags/{id}")
    Call<Tag> update(@Path("id") int id, @Body Tag body);

    @DELETE("products/tags/{id}")
    Call<Tag> delete(@Path("id") int id);

    @DELETE("products/tags/{id}")
    Call<Tag> delete(@Path("id") int id, @Query("force") boolean force);

    @POST("products/tags/batch")
    Call<String> batch(@Body Tag body);

}
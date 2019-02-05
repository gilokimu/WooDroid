package me.gilo.woodroid.data;


import me.gilo.woodroid.models.Attribute;
import me.gilo.woodroid.models.Coupon;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface AttributeAPI {

    @Headers("Content-Type: application/json")
    @POST("products/attributes")
    Call<Attribute> create(@Body Attribute body);

    @GET("products/attributes/{id}")
    Call<Attribute> view(@Path("id") int id);

    @GET("products/attributes")
    Call<List<Attribute>> list();

    @Headers("Content-Type: application/json")
    @PUT("products/attributes/{id}")
    Call<Attribute> update(@Path("id") int id, @Body Attribute body);

    @DELETE("products/attributes/{id}")
    Call<Attribute> delete(@Path("id") int id);

    @DELETE("products/attributes/{id}")
    Call<Attribute> delete(@Path("id") int id, @Query("force") boolean force);

    @POST("products/attributes/batch")
    Call<String> batch(@Body Attribute body);

}
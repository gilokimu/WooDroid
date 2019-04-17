package me.gilo.woodroid.data.api;


import me.gilo.woodroid.models.AttributeTerm;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

public interface ProductAttributeTermAPI {

    @Headers("Content-Type: application/json")
    @POST("products/attributes/{id}/terms")
    Call<AttributeTerm> create(@Path("id") int attribute_id, @Body AttributeTerm body);

    @GET("products/attributes/{id}/terms/[term_id]")
    Call<AttributeTerm> view(@Path("id") int attribute_id, @Path("term_id") int term_id);

    @GET("products/attributes/{id}/terms")
    Call<List<AttributeTerm>> list(@Path("id") int attribute_id);

    @Headers("Content-Type: application/json")
    @PUT("products/attributes/{id}/terms/[term_id]")
    Call<AttributeTerm> update(@Path("id") int attribute_id, @Path("term_id") int term_id, @Body AttributeTerm body);

    @DELETE("products/attributes/{id}/terms/[term_id]")
    Call<AttributeTerm> delete(@Path("id") int attribute_id, @Path("term_id") int term_id);

    @DELETE("products/attributes/{id}/terms/[term_id]")
    Call<AttributeTerm> delete(@Path("id") int attribute_id, @Path("term_id") int term_id, @Query("force") boolean force);

    @POST("products/attributes/batch")
    Call<String> batch(@Body AttributeTerm body);

    @GET("products/attributes/{id}/terms")
    Call<List<AttributeTerm>> filter(@Path("id") int attribute_id, @QueryMap Map<String, String> filter);

}
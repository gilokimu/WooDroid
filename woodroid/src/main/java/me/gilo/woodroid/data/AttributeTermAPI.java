package me.gilo.woodroid.data;


import me.gilo.woodroid.models.Attribute;
import me.gilo.woodroid.models.AttributeTerm;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface AttributeTermAPI {

    @Headers("Content-Type: application/json")
    @POST("products/attributes/{id}/terms")
    Call<AttributeTerm> create(@Body AttributeTerm body);

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

}
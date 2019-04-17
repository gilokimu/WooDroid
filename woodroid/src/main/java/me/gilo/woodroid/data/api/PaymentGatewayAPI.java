package me.gilo.woodroid.data.api;


import retrofit2.Call;
import me.gilo.woodroid.models.PaymentGateway;
import retrofit2.http.*;

import java.util.List;

public interface PaymentGatewayAPI {


    @GET("payment_gateways/{id}")
    Call<PaymentGateway> view(@Path("id") int id);

    @GET("payment_gateways")
    Call<List<PaymentGateway>> list();

    @Headers("Content-Type: application/json")
    @PUT("payment_gateways")
    Call<PaymentGateway> update(@Path("id") String id, @Body PaymentGateway body);

}
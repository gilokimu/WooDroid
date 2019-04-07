package me.gilo.woodroid.data.api;


import me.gilo.woodroid.callback.WooCall;
import me.gilo.woodroid.models.PaymentGateway;
import retrofit2.http.*;

import java.util.List;

public interface PaymentGatewayAPI {


    @GET("payment_gateways/{id}")
    WooCall<PaymentGateway> view(@Path("id") int id);

    @GET("payment_gateways")
    WooCall<List<PaymentGateway>> list();

    @Headers("Content-Type: application/json")
    @PUT("payment_gateways")
    WooCall<PaymentGateway> update(@Path("id") String id, @Body PaymentGateway body);

}
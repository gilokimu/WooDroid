package me.gilo.woodroid.repo;

import me.gilo.woodroid.callback.WooCall;
import me.gilo.woodroid.data.api.PaymentGatewayAPI;
import me.gilo.woodroid.models.PaymentGateway;

import java.util.List;

public class PaymentGatewayRepository extends WooRepository{

    private final PaymentGatewayAPI apiService;

    public PaymentGatewayRepository(String baseUrl, String consumerKey, String consumerSecret) {
       super( baseUrl, consumerKey, consumerSecret);
       apiService = retrofit.create(PaymentGatewayAPI.class);
    }

    public WooCall<PaymentGateway> paymentGateway(int id) {
        return apiService.view(id);
    }

    public WooCall<List<PaymentGateway>> paymentGateways() {
        return apiService.list();
    }

    public WooCall<PaymentGateway> update(String id, PaymentGateway paymentGateway) {
        return apiService.update(id, paymentGateway);
    }

}

package me.gilo.woodroid.repo;

import retrofit2.Call;

import me.gilo.woodroid.data.api.PaymentGatewayAPI;
import me.gilo.woodroid.models.PaymentGateway;

import java.util.List;

public class PaymentGatewayRepository extends WooRepository{

    private final PaymentGatewayAPI apiService;

    public PaymentGatewayRepository(String baseUrl, String consumerKey, String consumerSecret) {
       super( baseUrl, consumerKey, consumerSecret);
       apiService = retrofit.create(PaymentGatewayAPI.class);
    }

    public Call<PaymentGateway> paymentGateway(int id) {
        return apiService.view(id);
    }

    public Call<List<PaymentGateway>> paymentGateways() {
        return apiService.list();
    }

    public Call<PaymentGateway> update(String id, PaymentGateway paymentGateway) {
        return apiService.update(id, paymentGateway);
    }

}

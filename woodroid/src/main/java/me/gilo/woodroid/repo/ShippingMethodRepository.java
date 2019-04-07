package me.gilo.woodroid.repo;

import me.gilo.woodroid.callback.WooCall;
import me.gilo.woodroid.data.api.PaymentGatewayAPI;
import me.gilo.woodroid.data.api.ShippingMethodAPI;
import me.gilo.woodroid.models.PaymentGateway;
import me.gilo.woodroid.models.ShippingMethod;

import java.util.List;

public class ShippingMethodRepository extends WooRepository{

    private final ShippingMethodAPI apiService;

    public ShippingMethodRepository(String baseUrl, String consumerKey, String consumerSecret) {
       super( baseUrl, consumerKey, consumerSecret);
       apiService = retrofit.create(ShippingMethodAPI.class);
    }

    public WooCall<ShippingMethod> shippingMethod(String id) {
        return apiService.view(id);
    }

    public WooCall<List<ShippingMethod>> shippingMethods() {
        return apiService.list();
    }


}

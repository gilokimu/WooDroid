package me.gilo.wc.repo;


import me.gilo.wc.common.WooLiveData;
import me.gilo.woodroid.Woocommerce;
import me.gilo.woodroid.models.Order;

import javax.inject.Inject;

public class OrderRepository {

    @Inject
    Woocommerce woocommerce;


    @Inject
    public OrderRepository() {

    }

    public WooLiveData<Order> addToCart(int productId) {
        final WooLiveData<Order> callBack = new WooLiveData();

        woocommerce.OrderRepository().addToCart(productId).enqueue(callBack);
        return callBack;
    }

}

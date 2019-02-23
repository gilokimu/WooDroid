package me.gilo.wc.repo;


import me.gilo.wc.common.WooLiveData;
import me.gilo.woodroid.models.Order;
import me.gilo.woodroid.models.Product;
import me.gilo.woodroid.models.filters.ProductFilter;

import javax.inject.Inject;
import java.util.List;

public class OrderRepository extends WoocommerceRepository {

    @Inject
    public OrderRepository() {

    }

    public WooLiveData<Order> addToCart(int productId) {
        final WooLiveData<Order> callBack = new WooLiveData();

        woocommerce.OrderRepository().addToCart(productId).enqueue(callBack);
        return callBack;
    }

}

package me.gilo.wc.repo;


import me.gilo.wc.common.WooLiveData;
import me.gilo.woodroid.Woocommerce;
import me.gilo.woodroid.models.LineItem;
import me.gilo.woodroid.models.Order;

import javax.inject.Inject;
import java.util.Map;

public class CartRepository {

    @Inject
    Woocommerce woocommerce;


    @Inject
    public CartRepository() {

    }

    public WooLiveData<Map<String, LineItem>> addToCart(int productId) {
        final WooLiveData<Map<String, LineItem>> callBack = new WooLiveData();

        LineItem lineItem = new LineItem();
        lineItem.setProductId(productId);
        lineItem.setQuantity(1);

        woocommerce.CartRepository().addToCart(lineItem).enqueue(callBack);
        return callBack;
    }

    public WooLiveData<Map<String, LineItem>> cart() {
        final WooLiveData<Map<String, LineItem>> callBack = new WooLiveData();
        woocommerce.CartRepository().cart().enqueue(callBack);
        return callBack;
    }

}

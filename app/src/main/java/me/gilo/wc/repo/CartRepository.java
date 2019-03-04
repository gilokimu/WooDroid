package me.gilo.wc.repo;


import android.content.Context;
import me.gilo.wc.common.WooLiveData;
import me.gilo.wc.utils.AppUtils;
import me.gilo.woodroid.Woocommerce;
import me.gilo.woodroid.models.LineItem;

import javax.inject.Inject;
import java.util.Map;

public class CartRepository {

    @Inject
    Woocommerce woocommerce;


    @Inject
    public CartRepository() {

    }

    public WooLiveData<Map<String, LineItem>> addToCart(Context context, int productId) {
        final WooLiveData<Map<String, LineItem>> callBack = new WooLiveData();

        LineItem lineItem = new LineItem();
        lineItem.setProductId(productId);
        lineItem.setQuantity(1);

        woocommerce.CartRepository(context).addToCart(lineItem).enqueue(callBack);
        return callBack;
    }

    public WooLiveData<Map<String, LineItem>> cart(Context context) {
        final WooLiveData<Map<String, LineItem>> callBack = new WooLiveData();
        woocommerce.CartRepository(context).cart().enqueue(callBack);

        return callBack;
    }

    public void saveSession(Context context, String session, String expiry) {
        AppUtils appUtils = new AppUtils(context);
        appUtils.saveCartSession(session, expiry);
    }



}

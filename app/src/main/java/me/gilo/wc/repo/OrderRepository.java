package me.gilo.wc.repo;


import me.gilo.wc.common.WooLiveData;
import me.gilo.woodroid.Woocommerce;
import me.gilo.woodroid.models.Order;
import me.gilo.woodroid.models.filters.OrderFilter;

import javax.inject.Inject;
import java.util.List;

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

    public WooLiveData<Order> create(Order order) {
        final WooLiveData<Order> callBack = new WooLiveData();
        woocommerce.OrderRepository().create(order).enqueue(callBack);
        return callBack;
    }
    

    public WooLiveData<Order> order(int id) {
        final WooLiveData<Order> callBack = new WooLiveData();
        woocommerce.OrderRepository().order(id).enqueue(callBack);
        return callBack;
    }

    public WooLiveData<List<Order>> orders() {
        final WooLiveData<List<Order>> callBack = new WooLiveData();

        woocommerce.OrderRepository().orders().enqueue(callBack);

        return callBack;
    }

    public WooLiveData<List<Order>> orders(OrderFilter orderFilter) {
        final WooLiveData<List<Order>> callBack = new WooLiveData();
        woocommerce.OrderRepository().orders(orderFilter).enqueue(callBack);
        return callBack;
    }

    public WooLiveData<Order> update(int id, Order order) {
        final WooLiveData<Order> callBack = new WooLiveData();
        woocommerce.OrderRepository().update(id, order).enqueue(callBack);

        return callBack;
    }

    public WooLiveData<Order> delete(int id) {
        final WooLiveData<Order> callBack = new WooLiveData();
        woocommerce.OrderRepository().delete(id).enqueue(callBack);

        return callBack;
    }

    public WooLiveData<Order> delete(int id, boolean force) {
        final WooLiveData<Order> callBack = new WooLiveData();
        woocommerce.OrderRepository().delete(id, force).enqueue(callBack);

        return callBack;
    }


}

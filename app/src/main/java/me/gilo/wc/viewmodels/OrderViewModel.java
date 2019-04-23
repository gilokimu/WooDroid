package me.gilo.wc.viewmodels;

import android.arch.lifecycle.ViewModel;
import me.gilo.wc.common.WooLiveData;
import me.gilo.wc.repo.OrderRepository;
import me.gilo.wc.repo.ReviewRepository;
import me.gilo.woodroid.models.Order;
import me.gilo.woodroid.models.ProductReview;
import me.gilo.woodroid.models.filters.OrderFilter;

import javax.inject.Inject;
import java.util.List;


public final class OrderViewModel extends ViewModel {
    private final OrderRepository orderRepository;

    @Inject
    OrderViewModel(OrderRepository orderRepository) {
        this.orderRepository =  orderRepository;
    }

    public WooLiveData<Order> addToCart(int productId) {
        return orderRepository.addToCart(productId);
    }

    public WooLiveData<Order> create(Order order) {
       return orderRepository.create(order);
    }


    public WooLiveData<Order> order(int id) {

        return orderRepository.order(id);
    }

    public WooLiveData<List<Order>> orders() {
        return orderRepository.orders();
    }

    public WooLiveData<List<Order>> orders(OrderFilter orderFilter) {
        return orderRepository.orders(orderFilter);
    }

    public WooLiveData<Order> update(int id, Order order) {
        return orderRepository.update(id, order);
    }

    public WooLiveData<Order> delete(int id) {
        return orderRepository.delete(id);
    }

    public WooLiveData<Order> delete(int id, boolean force) {
        return orderRepository.delete(id, force);
    }

}
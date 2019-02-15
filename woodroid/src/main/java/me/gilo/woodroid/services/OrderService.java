package me.gilo.woodroid.services;

import me.gilo.woodroid.models.Order;
import me.gilo.woodroid.repo.OrderRepository;
import retrofit2.Call;

import java.util.List;

public class OrderService {

    final OrderRepository orderRepository;

    public OrderService(String baseUrl, String consumerKey, String consumerSecret) {
        orderRepository = new OrderRepository(baseUrl, consumerKey, consumerSecret);
    }

    public Call<Order> create(Order order) {
        return orderRepository.create(order);
    }


    public Call<Order> order(int id) {
        return orderRepository.order(id);
    }

    public Call<List<Order>> orders() {
        return orderRepository.orders();
    }

    public Call<Order> update(int id, Order order) {
        return orderRepository.update(id, order);
    }

    public Call<Order> delete(int id) {
        return orderRepository.delete(id);
    }

    public Call<Order> delete(int id, boolean force) {
        return orderRepository.delete(id, force);
    }

}

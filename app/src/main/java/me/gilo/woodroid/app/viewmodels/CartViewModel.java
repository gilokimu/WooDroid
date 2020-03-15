package me.gilo.woodroid.app.viewmodels;

import androidx.lifecycle.ViewModel;
import android.content.Context;
import com.google.firebase.firestore.DocumentReference;
import me.gilo.woodroid.app.common.CompletionGenericLiveData;
import me.gilo.woodroid.app.common.QueryLiveData;
import me.gilo.woodroid.app.common.WooLiveData;
import me.gilo.woodroid.app.models.CartLineItem;
import me.gilo.woodroid.app.repo.CartRepository;
import me.gilo.woodroid.app.repo.CustomerRepository;
import me.gilo.woodroid.app.repo.OrderRepository;

import me.gilo.woodroid.models.*;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;


public final class CartViewModel extends ViewModel {

    private final CartRepository cartRepository;
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    @Inject
    CartViewModel(CartRepository cartRepository, OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.cartRepository =  cartRepository;
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    public QueryLiveData<CartLineItem> cart() {
        return cartRepository.cart();
    }

    public CompletionGenericLiveData<Void> deleteItem(CartLineItem cartLineItem) {
        return cartRepository.deleteItem(cartLineItem);
    }

    public CompletionGenericLiveData<Void> deleteAllCartItems() {
        return cartRepository.deleteItems();
    }

    public CompletionGenericLiveData<Void> setQuantity(CartLineItem cartLineItem, int quantity) {
        return cartRepository.setQuantity(cartLineItem, quantity);
    }

    public WooLiveData<Order> createOrder(Order order) {
        return orderRepository.create(order);
    }

    public WooLiveData<List<Customer>> currentCustomer() {
        return customerRepository.currentCustomer();
    }

}
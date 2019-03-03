package me.gilo.wc.viewmodels;

import android.arch.lifecycle.ViewModel;
import me.gilo.wc.common.WooLiveData;
import me.gilo.wc.repo.CartRepository;
import me.gilo.wc.repo.OrderRepository;
import me.gilo.wc.repo.ProductRepository;
import me.gilo.woodroid.models.LineItem;
import me.gilo.woodroid.models.Order;
import me.gilo.woodroid.models.Product;
import me.gilo.woodroid.models.filters.ProductFilter;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;


public final class ProductViewModel extends ViewModel {
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;

    @Inject
    ProductViewModel(ProductRepository productRepository,
                     OrderRepository orderRepository,
                     CartRepository cartRepository
    ) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.cartRepository =  cartRepository;
    }

    public WooLiveData<List<Product>> products() {
        return productRepository.products();
    }

    public WooLiveData<Map<String, LineItem>> addToCart(int productId) {
        return cartRepository.addToCart(productId);
    }

    public WooLiveData<Map<String, LineItem>> cart() {
        return cartRepository.cart();
    }

    public WooLiveData<List<Product>> products(ProductFilter filter) {
        return productRepository.products(filter);
    }

    public WooLiveData<Product> product(int productId) {
        return productRepository.product(productId);
    }

    public WooLiveData<List<Product>> search(String term) {
        return productRepository.search(term);
    }
}
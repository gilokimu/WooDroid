package me.gilo.wc.viewmodels;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import com.google.firebase.firestore.DocumentReference;
import me.gilo.wc.common.CompletionGenericLiveData;
import me.gilo.wc.common.QueryLiveData;
import me.gilo.wc.common.WooLiveData;
import me.gilo.wc.models.CartLineItem;
import me.gilo.wc.repo.CartRepository;
import me.gilo.wc.repo.OrderRepository;
import me.gilo.wc.repo.ProductRepository;
import me.gilo.woodroid.models.LineItem;
import me.gilo.woodroid.models.Product;
import me.gilo.woodroid.models.ProductReview;
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

    public CompletionGenericLiveData<DocumentReference> addToCart(int productId, float price) {
        return cartRepository.addToCart(productId, price);
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

    public WooLiveData<Map<String, LineItem>> cart(Context context) {
        return cartRepository.cart(context);
    }

    public WooLiveData<List<Product>> products(ProductFilter filter) {
        return productRepository.products(filter);
    }

    public WooLiveData<Product> product(int productId) {
        return productRepository.product(productId);
    }


    public WooLiveData<List<ProductReview>> reviews(int productId) {
        return productRepository.reviews(productId);
    }

    public WooLiveData<List<Product>> search(String term) {
        return productRepository.search(term);
    }
}
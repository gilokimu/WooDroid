package me.gilo.woodroid.app.viewmodels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import com.google.firebase.firestore.DocumentReference;
import me.gilo.woodroid.app.common.CompletionGenericLiveData;
import me.gilo.woodroid.app.common.QueryLiveData;
import me.gilo.woodroid.app.common.WooLiveData;
import me.gilo.woodroid.app.models.CartLineItem;
import me.gilo.woodroid.app.repo.CartRepository;
import me.gilo.woodroid.app.repo.OrderRepository;
import me.gilo.woodroid.app.repo.ProductRepository;
import me.gilo.woodroid.models.LineItem;
import me.gilo.woodroid.models.Order;
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

    private final MutableLiveData<Integer> selectedProductId = new MutableLiveData();

    @Inject
    ProductViewModel(ProductRepository productRepository,
                     OrderRepository orderRepository,
                     CartRepository cartRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.cartRepository =  cartRepository;
    }

    public MutableLiveData<Integer> getSelectedProduct() {
        return selectedProductId;
    }

    public void selectProduct(int productId) {
        selectedProductId.setValue(productId);
    }

    public WooLiveData<List<Product>> products() {
        return productRepository.products();
    }

    public CompletionGenericLiveData<DocumentReference> addToCart(Product product) {
        return cartRepository.addToCart(product);
    }

    public WooLiveData<Order> addToCart(int productId) {
        return orderRepository.addToCart(productId);
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
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


public final class CartViewModel extends ViewModel {

    private final CartRepository cartRepository;

    @Inject
    CartViewModel(CartRepository cartRepository) {
        this.cartRepository =  cartRepository;
    }

    public CompletionGenericLiveData<DocumentReference> addToCart(Product product) {
        return cartRepository.addToCart(product);
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

}
package me.gilo.wc.repo;


import android.arch.lifecycle.Observer;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.*;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import me.gilo.wc.common.CompletionGenericLiveData;
import me.gilo.wc.common.QueryLiveData;
import me.gilo.wc.common.WooLiveData;
import me.gilo.wc.models.CartLineItem;
import me.gilo.wc.utils.AppUtils;
import me.gilo.woodroid.Woocommerce;
import me.gilo.woodroid.models.LineItem;

import javax.inject.Inject;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CartRepository {

    @Inject
    Woocommerce woocommerce;

    private final CollectionReference cart;

    @Inject
    public CartRepository() {
        this.cart = FirebaseFirestore.getInstance()
                .collection("users")
                .document(FirebaseAuth.getInstance().getCurrentUser().getUid())
                .collection("cart");

    }

    public QueryLiveData<CartLineItem> cart() {
        return new QueryLiveData<>(cart, CartLineItem.class);
    }

    public CompletionGenericLiveData<Void> deleteItem(CartLineItem cartLineItem) {
        final CompletionGenericLiveData<Void> completion = new CompletionGenericLiveData();
        cart.document(cartLineItem.getId()).delete().addOnCompleteListener(completion);

        return completion;
    }

    public CompletionGenericLiveData<Void> setQuantity(CartLineItem cartLineItem, int quantity) {
        final CompletionGenericLiveData<Void> completion = new CompletionGenericLiveData();
        cartLineItem.setQuantity(quantity);

        cart.document(cartLineItem.getId()).set(cartLineItem).addOnCompleteListener(completion);

        return completion;
    }

    public CompletionGenericLiveData<Void> deleteItems() {
        final CompletionGenericLiveData<Void> completion = new CompletionGenericLiveData();
        deleteCartItems().addOnCompleteListener(completion);
        return completion;
    }


    private Task<Void> deleteCartItems() {
        return cart.getFirestore().runTransaction(transaction -> {
            cart.get().addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        cart.document(document.getId()).delete();
                    }

                } else {
                }
            });

            return null;
        });
    }


    public CompletionGenericLiveData<DocumentReference> addToCart(int productId, float price) {
        final CompletionGenericLiveData<DocumentReference> completion = new CompletionGenericLiveData();

        CartLineItem lineItem = new CartLineItem();
        lineItem.setProductId(productId);
        lineItem.setPrice(price);
        lineItem.setQuantity(1);

        cart.add(lineItem).addOnCompleteListener(completion);

        return completion;

    }

    public WooLiveData<Map<String, LineItem>> cart(Context context) {
        final WooLiveData<Map<String, LineItem>> callBack = new WooLiveData();
        woocommerce.CartRepository(context).cart().enqueue(callBack);

        return callBack;
    }

}

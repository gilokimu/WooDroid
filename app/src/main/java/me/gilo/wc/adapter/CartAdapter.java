package me.gilo.wc.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import me.gilo.wc.R;
import me.gilo.wc.adapter.viewholder.CartViewHolder;
import me.gilo.wc.adapter.viewholder.CategoryViewHolder;
import me.gilo.wc.models.CartLineItem;
import me.gilo.woodroid.models.CartItem;
import me.gilo.woodroid.models.Category;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartViewHolder> {
    private List<CartLineItem> cartLineItems;

    public CartAdapter(List<CartLineItem> cartLineItems) {
        this.cartLineItems = cartLineItems;
    }

    @Override
    public CartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CartViewHolder(parent.getContext(), LayoutInflater.from(parent.getContext()).inflate(R.layout.single_cart_item, parent, false));
    }

    @Override
    public void onBindViewHolder(CartViewHolder holder, int position) {
        holder.renderView(cartLineItems.get(position));
    }


    @Override
    public int getItemCount() {
        return cartLineItems.size() == 0 ? 0 : cartLineItems.size();
    }
}

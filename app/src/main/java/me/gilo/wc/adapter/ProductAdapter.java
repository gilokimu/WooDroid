package me.gilo.wc.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import me.gilo.wc.R;
import me.gilo.wc.adapter.viewholder.MenuViewHolder;
import me.gilo.wc.adapter.viewholder.ProductViewHolder;
import me.gilo.woodroid.models.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder> {
    private List<Product> products;

    public ProductAdapter(List<Product> products) {
        this.products = products;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ProductViewHolder(parent.getContext(), LayoutInflater.from(parent.getContext()).inflate(R.layout.single_product_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        holder.renderView(products.get(position));
    }


    @Override
    public int getItemCount() {
        return products.size() == 0 ? 0 : products.size();
    }
}

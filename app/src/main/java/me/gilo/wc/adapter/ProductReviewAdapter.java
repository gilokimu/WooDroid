package me.gilo.wc.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import me.gilo.wc.R;
import me.gilo.wc.adapter.viewholder.ProductReviewViewHolder;
import me.gilo.wc.adapter.viewholder.ProductViewHolder;
import me.gilo.woodroid.models.Product;
import me.gilo.woodroid.models.ProductReview;

import java.util.List;

public class ProductReviewAdapter extends RecyclerView.Adapter<ProductReviewViewHolder> {
    private List<ProductReview> reviews;

    public ProductReviewAdapter(List<ProductReview> reviews) {
        this.reviews = reviews;
    }

    @Override
    public ProductReviewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ProductReviewViewHolder(parent.getContext(), LayoutInflater.from(parent.getContext()).inflate(R.layout.single_product_review, parent, false));
    }

    @Override
    public void onBindViewHolder(ProductReviewViewHolder holder, int position) {
        holder.renderView(reviews.get(position));
    }


    @Override
    public int getItemCount() {
        return reviews.size() == 0 ? 0 : reviews.size();
    }
}

package me.gilo.wc.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import me.gilo.wc.R;
import me.gilo.wc.adapter.viewholder.CategoryViewHolder;
import me.gilo.woodroid.models.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {
    private List<Category> categories;

    public CategoryAdapter(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CategoryViewHolder(parent.getContext(), LayoutInflater.from(parent.getContext()).inflate(R.layout.single_category_item, parent, false));
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        holder.renderView(categories.get(position));
    }


    @Override
    public int getItemCount() {
        return categories.size() == 0 ? 0 : categories.size();
    }
}

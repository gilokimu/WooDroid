package me.gilo.wc.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import me.gilo.wc.R
import me.gilo.wc.adapter.viewholder.CategoryViewHolder
import me.gilo.woodroid.models.Category

class CategoryAdapter(private val categories: List<Category>) : RecyclerView.Adapter<CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            parent.context,
            LayoutInflater.from(parent.context).inflate(R.layout.single_category_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.renderView(categories[position])
    }


    override fun getItemCount(): Int {
        return if (categories.isEmpty()) 0 else categories.size
    }
}

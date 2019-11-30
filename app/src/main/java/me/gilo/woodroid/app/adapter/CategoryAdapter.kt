package me.gilo.woodroid.app.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import me.gilo.woodroid.app.R
import me.gilo.woodroid.app.adapter.viewholder.CategoryViewHolder
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

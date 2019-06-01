package me.gilo.woodroid.app.adapter.viewholder

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import me.gilo.woodroid.app.R
import me.gilo.woodroid.app.ui.product.ShopActivity
import me.gilo.woodroid.models.Category

class CategoryViewHolder(val context: Context, itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    fun renderView(category: Category) {
        val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)

        tvTitle.text = category.name

        itemView.setOnClickListener{
            val intent = Intent(context, ShopActivity::class.java)
            intent.putExtra("categoryId",category.id)
            intent.putExtra("name",category.name)

            context.startActivity(intent)
        }
    }


}
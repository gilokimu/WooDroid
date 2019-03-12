package me.gilo.wc.adapter.viewholder

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.text.Html
import android.view.View
import android.widget.TextView
import me.gilo.wc.R
import me.gilo.wc.ui.product.ShopActivity
import me.gilo.woodroid.models.Category

class CategoryViewHolder(val context: Context, itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    fun renderView(category: Category) {
        val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        val tvDescription = itemView.findViewById<TextView>(R.id.tvDescription)

        tvTitle.text = category.name
        tvDescription.text = Html.fromHtml(category.description)

        itemView.setOnClickListener{
            val intent = Intent(context, ShopActivity::class.java)
            intent.putExtra("categoryId",category.id)
            intent.putExtra("name",category.name)

            context.startActivity(intent)
        }
    }


}
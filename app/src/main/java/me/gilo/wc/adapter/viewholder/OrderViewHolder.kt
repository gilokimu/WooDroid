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
import me.gilo.woodroid.models.Order

class OrderViewHolder(val context: Context, itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    fun renderView(order: Order) {
        val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        tvTitle.text = order.orderNumber

    }


}
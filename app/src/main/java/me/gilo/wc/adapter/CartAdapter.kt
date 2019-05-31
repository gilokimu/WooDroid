package me.gilo.wc.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import me.gilo.wc.R
import me.gilo.wc.adapter.viewholder.CartViewHolder
import me.gilo.wc.adapter.viewholder.CategoryViewHolder
import me.gilo.wc.models.CartLineItem
import me.gilo.woodroid.models.CartItem
import me.gilo.woodroid.models.Category

class CartAdapter(private val cartLineItems: List<CartLineItem>) : RecyclerView.Adapter<CartViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        return CartViewHolder(
            parent.context,
            LayoutInflater.from(parent.context).inflate(R.layout.single_cart_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.renderView(cartLineItems[position])
    }


    override fun getItemCount(): Int {
        return if (cartLineItems.isEmpty()) 0 else cartLineItems.size
    }
}

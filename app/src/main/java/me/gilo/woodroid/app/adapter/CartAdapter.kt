package me.gilo.woodroid.app.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import me.gilo.woodroid.app.R
import me.gilo.woodroid.app.adapter.viewholder.CartViewHolder
import me.gilo.woodroid.app.models.CartLineItem

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

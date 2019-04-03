package me.gilo.wc.adapter.viewholder

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.text.Html
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import me.gilo.woodroid.models.Product
import android.text.Spannable
import android.text.style.ForegroundColorSpan
import android.text.SpannableString
import android.graphics.Color
import kotlinx.android.synthetic.main.content_product.*
import me.gilo.wc.R
import me.gilo.wc.models.CartLineItem
import me.gilo.wc.ui.coupon.CouponActivity
import me.gilo.wc.ui.product.ProductActivity
import me.gilo.woodroid.models.CartItem


class CartViewHolder(val context: Context, itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    fun renderView(cartLineItem: CartLineItem) {
        val ivImage = itemView.findViewById<ImageView>(R.id.ivImage)
        val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        val tvPrice = itemView.findViewById<TextView>(R.id.tvPrice)

        tvTitle.text = cartLineItem.name

        if (cartLineItem.imageUrl.isNotEmpty()){
            Picasso.with(context).load(cartLineItem.imageUrl).into(ivImage)
        }

        tvPrice.text = cartLineItem.priceString;


        itemView.setOnClickListener{
            val intent = Intent(context, ProductActivity::class.java)
            intent.putExtra("productId", cartLineItem.productId)

            context.startActivity(intent)
        }

    }


}
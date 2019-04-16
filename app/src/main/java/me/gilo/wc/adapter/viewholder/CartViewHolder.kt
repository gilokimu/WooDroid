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
import me.gilo.wc.events.AddQuantityEvent
import me.gilo.wc.events.LessQuantityEvent
import me.gilo.wc.events.ProductEvent
import me.gilo.wc.models.CartLineItem
import me.gilo.wc.ui.coupon.CouponActivity
import me.gilo.wc.ui.product.ProductActivity
import me.gilo.woodroid.models.CartItem
import org.greenrobot.eventbus.EventBus


class CartViewHolder(val context: Context, itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    fun renderView(cartLineItem: CartLineItem) {
        val ivImage = itemView.findViewById<ImageView>(R.id.ivImage)
        val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        val tvDescription = itemView.findViewById<TextView>(R.id.tvDescription)
        val tvPrice = itemView.findViewById<TextView>(R.id.tvPrice)

        val tvAdd = itemView.findViewById<TextView>(R.id.tvAdd)
        val tvQty = itemView.findViewById<TextView>(R.id.tvQty)
        val tvLess = itemView.findViewById<TextView>(R.id.tvReduce)


        tvQty.text = "" + cartLineItem.quantity

        var product = cartLineItem.product

        tvTitle.text = cartLineItem.name
        tvDescription.text = Html.fromHtml(product.description)

        if (product.images != null && product.images.isNotEmpty()){
            Picasso.with(context).load(product.images[0].src).into(ivImage)
        }

        tvTitle.text = product.name

        val regularPrice = product.regular_price
        val salePrice = product.sale_price

        if (product.isOn_sale) {
            tvPrice.text = SpannableString("Ksh$salePrice")
        }else{
            tvPrice.text = SpannableString("Ksh$regularPrice")
        }


        itemView.setOnClickListener{
            val intent = Intent(context, ProductActivity::class.java)
            intent.putExtra("productId", cartLineItem.productId)

            context.startActivity(intent)
        }

        tvAdd.setOnClickListener{
            EventBus.getDefault().post(AddQuantityEvent(cartLineItem))
        }

        tvLess.setOnClickListener{
            EventBus.getDefault().post(LessQuantityEvent(cartLineItem))
        }

    }


}
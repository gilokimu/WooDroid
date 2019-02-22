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
import me.gilo.wc.ui.coupon.CouponActivity
import me.gilo.wc.ui.product.ProductActivity


class ProductViewHolder(val context: Context, itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    fun renderView(product: Product) {
        val ivImage = itemView.findViewById<ImageView>(R.id.ivImage)
        val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        val tvDescription = itemView.findViewById<TextView>(R.id.tvDescription)
        val tvCallToAction = itemView.findViewById<TextView>(R.id.tvCallToAction)
        val tvOnSale = itemView.findViewById<TextView>(R.id.tvOnSale)

        tvTitle.text = product.name
        tvDescription.text = Html.fromHtml(product.description)

        if (product.images != null && product.images.isNotEmpty()){
            Picasso.with(context).load(product.images[0].src).into(ivImage)
        }

        val regularPrice = product.regular_price
        val salePrice = product.sale_price

        val price =  SpannableString("$$regularPrice $$salePrice")
        if (product.isOn_sale) {
            tvCallToAction.text = Html.fromHtml(product.price_html)

            tvOnSale.visibility = View.VISIBLE
        }else{
            tvCallToAction.text = Html.fromHtml(product.price_html)
            tvOnSale.visibility = View.GONE
        }

        itemView.setOnClickListener{
            val intent = Intent(context, ProductActivity::class.java)
            intent.putExtra("productId", product.id)

            context.startActivity(intent)
        }

    }


}
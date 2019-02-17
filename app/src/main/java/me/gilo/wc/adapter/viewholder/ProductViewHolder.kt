package me.gilo.wc.adapter.viewholder

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.Html
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import me.gilo.wc.R
import me.gilo.woodroid.models.Product

class ProductViewHolder(val context: Context, itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    fun renderView(product: Product) {
        val ivImage = itemView.findViewById<ImageView>(R.id.ivImage)
        val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        val tvDescription = itemView.findViewById<TextView>(R.id.tvDescription)
        val tvCallToAction = itemView.findViewById<TextView>(R.id.tvCallToAction)

        tvTitle.text = product.name
        tvDescription.text = Html.fromHtml(product.description)
        tvCallToAction.text =  Html.fromHtml(product.price_html)

        if (product.images != null && product.images.isNotEmpty()){
            Picasso.with(context).load(product.images[0].src).into(ivImage)
        }
    }


}
package me.gilo.wc.adapter.viewholder

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.text.Html
import android.view.View
import android.widget.RatingBar
import android.widget.TextView
import me.gilo.wc.R
import me.gilo.wc.ui.product.ShopActivity
import me.gilo.wc.utils.DateUtils
import me.gilo.woodroid.models.Category
import me.gilo.woodroid.models.ProductReview

class ProductReviewViewHolder(val context: Context, itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    fun renderView(review: ProductReview) {
        val tvName = itemView.findViewById<TextView>(R.id.tvName)
        val tvDate = itemView.findViewById<TextView>(R.id.tvDate)
        val rbRating = itemView.findViewById<RatingBar>(R.id.rbRating)
        val tvMessage = itemView.findViewById<TextView>(R.id.tvMessage)

        tvName.text = review.reviewer
        tvMessage.text = Html.fromHtml(review.review)

        rbRating.rating = review.rating.toFloat()
        tvDate.text = DateUtils.getDateString_shortAndSmart(review.date_created)

    }


}
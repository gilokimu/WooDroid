package me.gilo.woodroid.app.adapter.viewholder

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.text.Html
import android.view.View
import android.widget.TextView
import me.gilo.woodroid.app.R
import me.gilo.woodroid.app.ui.coupon.CouponActivity
import me.gilo.woodroid.models.Coupon

class CouponViewHolder(val context: Context, itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    fun renderView(coupon: Coupon) {
        val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        val tvDescription = itemView.findViewById<TextView>(R.id.tvDescription)

        tvTitle.text = coupon.code.toUpperCase()
        tvDescription.text = Html.fromHtml(coupon.description)

        itemView.setOnClickListener{
            val intent = Intent(context, CouponActivity::class.java)
            intent.putExtra("couponId", coupon.id)

            context.startActivity(intent)
        }
    }


}
package me.gilo.wc.adapter.viewholder

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.text.Html
import android.text.SpannableString
import android.view.View
import android.widget.TextView
import me.gilo.wc.R
import me.gilo.wc.ui.order.OrderActivity
import me.gilo.wc.ui.product.ShopActivity
import me.gilo.wc.utils.DateUtils
import me.gilo.wc.utils.StringFormatter
import me.gilo.woodroid.models.Category
import me.gilo.woodroid.models.Order

class OrderViewHolder(val context: Context, itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    fun renderView(order: Order) {
        val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        val tvDescription = itemView.findViewById<TextView>(R.id.tvDescription)
        val tvPrice = itemView.findViewById<TextView>(R.id.tvPrice)
        val tvStatus = itemView.findViewById<TextView>(R.id.tvStatus)
        val tvDate = itemView.findViewById<TextView>(R.id.tvDate)



        tvTitle.text = "#" + order.orderNumber
        tvStatus.text = order.status

        tvDate.text = DateUtils.getDateString_shortAndSmart(order.getDateCreated())

        tvPrice.text = SpannableString("Ksh${order.total}")

        var description = ""

        for (lineItem in order.lineItems){
            description += lineItem.name + "(" + lineItem.quantity + "), "
        }


        tvDescription.text = description

        itemView.setOnClickListener{
            var intent = Intent(context, OrderActivity::class.java)
            intent.putExtra("orderId", order.id)
            context.startActivity(intent)
        }

    }


}
package me.gilo.woodroid.app.ui.order

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_my_orders.*
import kotlinx.android.synthetic.main.content_my_orders.*
import kotlinx.android.synthetic.main.state_empty.*
import me.gilo.woodroid.app.R
import me.gilo.woodroid.app.adapter.OrderAdapter
import me.gilo.woodroid.app.common.Status
import me.gilo.woodroid.app.ui.WooDroidActivity
import me.gilo.woodroid.app.ui.home.HomeActivity
import me.gilo.woodroid.app.viewmodels.OrderViewModel
import me.gilo.woodroid.models.Order

class MyOrdersActivity : WooDroidActivity<OrderViewModel>() {


    override lateinit var viewModel: OrderViewModel
    var orders: ArrayList<Order> = ArrayList()

    lateinit var adapter: OrderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_orders)
        setSupportActionBar(toolbar)

        viewModel = getViewModel(OrderViewModel::class.java)
        title = "My Orders"

        val layoutManager = LinearLayoutManager(
            baseContext,
            LinearLayoutManager.VERTICAL,
            false
        )
        rvOrders.layoutManager = layoutManager
        rvOrders.isNestedScrollingEnabled = false

        orders = ArrayList()

        adapter = OrderAdapter(orders)
        rvOrders.adapter = adapter

        orders()

        llEmptyState_layout.visibility = View.GONE

    }

    private fun showEmpty(title : String, description : String) {
        tvEmptyState_title.text = title
        tvEmptyState_description.text = description

        llEmptyState_layout.visibility = View.VISIBLE

        bEmptyState_action.setOnClickListener{
            startActivity(Intent(baseContext, HomeActivity::class.java))
        }
    }

    private fun orders() {
        viewModel.orders().observe(this, androidx.lifecycle.Observer { response ->
            when (response!!.status()) {
                Status.LOADING -> {
                    showLoading()
                }

                Status.SUCCESS -> {
                    orders.clear()
                    stopShowingLoading()

                    for (order in response.data()) {
                        orders.add(order)

                    }

                    adapter.notifyDataSetChanged()

                }

                Status.ERROR -> {
                    stopShowingLoading()
                }

                Status.EMPTY -> {
                    stopShowingLoading()

                    showEmpty("No orders", "Seems like you haven't ordered anything yet!")
                }
            }

        })

    }
}

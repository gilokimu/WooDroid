package me.gilo.wc.ui.order

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import kotlinx.android.synthetic.main.activity_my_orders.*
import kotlinx.android.synthetic.main.content_my_orders.*
import kotlinx.android.synthetic.main.state_empty.*
import me.gilo.wc.R
import me.gilo.wc.adapter.OrderAdapter
import me.gilo.wc.common.Status
import me.gilo.wc.ui.WooDroidActivity
import me.gilo.wc.ui.home.HomeActivity
import me.gilo.wc.viewmodels.OrderViewModel
import me.gilo.woodroid.models.Order

class MyOrdersActivity : WooDroidActivity<OrderViewModel>() {


    override lateinit var viewModel: OrderViewModel
    var orders: ArrayList<Order> = ArrayList()

    lateinit var adapter: OrderAdapter

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_orders)
        setSupportActionBar(toolbar)

        viewModel = getViewModel(OrderViewModel::class.java)
        title = "My Orders"

        val layoutManager = LinearLayoutManager(baseContext, LinearLayoutManager.VERTICAL, false)
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
        viewModel.orders().observe(this, android.arch.lifecycle.Observer { response ->
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

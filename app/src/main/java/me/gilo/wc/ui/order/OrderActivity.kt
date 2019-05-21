package me.gilo.wc.ui.order

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import me.gilo.wc.R

import kotlinx.android.synthetic.main.activity_order.*
import me.gilo.wc.adapter.OrderAdapter
import me.gilo.wc.common.Status
import me.gilo.wc.ui.WooDroidActivity
import me.gilo.wc.viewmodels.OrderViewModel
import me.gilo.woodroid.models.Order

class OrderActivity : WooDroidActivity<OrderViewModel>() {


    override lateinit var viewModel: OrderViewModel
    var orders: ArrayList<Order> = ArrayList()

    lateinit var adapter: OrderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        setSupportActionBar(toolbar)

        viewModel = getViewModel(OrderViewModel::class.java)
        title = "Orders"
    }

    private fun order(orderId : Int) {
        viewModel.order(orderId).observe(this, android.arch.lifecycle.Observer { response ->
            when (response!!.status()) {
                Status.LOADING -> {
                    showLoading()
                }

                Status.SUCCESS -> {
                    stopShowingLoading()

                }

                Status.ERROR -> {
                    stopShowingLoading()
                }

                Status.EMPTY -> {
                    stopShowingLoading()


                }
            }

        })

    }

}

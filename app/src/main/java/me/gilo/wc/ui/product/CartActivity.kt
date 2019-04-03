package me.gilo.wc.ui.product

import android.content.Context
import android.os.Bundle
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import kotlinx.android.synthetic.main.activity_cart.*
import me.gilo.wc.R
import me.gilo.wc.common.Status
import me.gilo.wc.models.CartLineItem
import me.gilo.wc.ui.WooDroidActivity
import me.gilo.wc.viewmodels.CartViewModel

class CartActivity : WooDroidActivity<CartViewModel>() {


    override lateinit var viewModel : CartViewModel
    var cartItems : ArrayList<CartLineItem> = ArrayList()

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        setSupportActionBar(toolbar)

        viewModel = getViewModel(CartViewModel::class.java)
        title = "Cart"

        cart()

    }

    private fun cart() {
        viewModel.cart().observe(this, android.arch.lifecycle.Observer { response ->
            when (response!!.status()) {
                Status.LOADING -> {

                }

                Status.SUCCESS -> {
                    cartItems.clear()

                    for (cartItem in response.data()){
                        cartItems.add(cartItem)

                    }
                }

                Status.ERROR -> {

                }

                Status.EMPTY -> {

                }
            }

        })

    }




}

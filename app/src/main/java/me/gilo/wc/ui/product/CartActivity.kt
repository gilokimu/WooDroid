package me.gilo.wc.ui.product

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.text.SpannableString
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import kotlinx.android.synthetic.main.activity_cart.*
import kotlinx.android.synthetic.main.content_cart.*
import kotlinx.android.synthetic.main.single_cart_item.*
import me.gilo.wc.R
import me.gilo.wc.adapter.CartAdapter
import me.gilo.wc.common.Status
import me.gilo.wc.events.AddQuantityEvent
import me.gilo.wc.events.LessQuantityEvent
import me.gilo.wc.events.ProductEvent
import me.gilo.wc.models.CartLineItem
import me.gilo.wc.ui.WooDroidActivity
import me.gilo.wc.viewmodels.CartViewModel
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class CartActivity : WooDroidActivity<CartViewModel>() {


    override lateinit var viewModel: CartViewModel
    var cartItems: ArrayList<CartLineItem> = ArrayList()

    lateinit var adapter: CartAdapter

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        setSupportActionBar(toolbar)

        viewModel = getViewModel(CartViewModel::class.java)
        title = "Cart"

        val layoutManager = LinearLayoutManager(baseContext, LinearLayoutManager.VERTICAL, false)
        rvCart.layoutManager = layoutManager
        rvCart.isNestedScrollingEnabled = false

        cartItems = ArrayList()

        adapter = CartAdapter(cartItems)
        rvCart.adapter = adapter

        cart()



    }

    private fun cart() {
        viewModel.cart().observe(this, android.arch.lifecycle.Observer { response ->
            when (response!!.status()) {
                Status.LOADING -> {
                    showLoading()
                }

                Status.SUCCESS -> {
                    cartItems.clear()
                    stopShowingLoading()

                    for (cartItem in response.data()) {
                        cartItems.add(cartItem)

                    }

                    adapter.notifyDataSetChanged()

                    setUpPage()
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

    private fun setUpPage() {
        var itemCount = cartItems.size
        var total = 0

        for (cartitem in cartItems){
            var price = if (cartitem.product.isOn_sale) {
                cartitem.product.sale_price.toInt()
            }else{
                cartitem.product.regular_price.toInt()
            }

            var qty = cartitem.quantity

            total += price * qty

        }

        if (itemCount == 1){
            tvTotalItemCountTitle.text = "Item ($itemCount)"
        }else{
            tvTotalItemCountTitle.text = "Items ($itemCount)"
        }

        tvTotalItemCost.text = "$$total"
        tvTotal.text = "$$total"
    }


    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(event: AddQuantityEvent) {
        var cartLineItem = event.cartLineItem
        var quantity = cartLineItem.quantity + 1

        updateCart(cartLineItem, quantity)

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(event: LessQuantityEvent) {
        var cartLineItem = event.cartLineItem
        var quantity = cartLineItem.quantity - 1

        if (quantity == 0) {
            delete(cartLineItem)
        } else {
            updateCart(cartLineItem, quantity)
        }
    }

    private fun updateCart(cartLineItem: CartLineItem, quantity: Int) {
        viewModel.setQuantity(cartLineItem, quantity).observe(this, android.arch.lifecycle.Observer { response ->
            when (response!!.status()) {
                Status.LOADING -> {

                }

                Status.SUCCESS -> {

                }

                Status.ERROR -> {

                }

                Status.EMPTY -> {

                }
            }

        })

    }


    private fun delete(cartLineItem: CartLineItem) {
        viewModel.deleteItem(cartLineItem).observe(this, android.arch.lifecycle.Observer { response ->
            when (response!!.status()) {
                Status.LOADING -> {

                }

                Status.SUCCESS -> {

                }

                Status.ERROR -> {

                }

                Status.EMPTY -> {

                }
            }

        })

    }


}

package me.gilo.woodroid.app.ui.product

import androidx.lifecycle.Observer
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import kotlinx.android.synthetic.main.activity_cart.*
import kotlinx.android.synthetic.main.content_cart.*
import kotlinx.android.synthetic.main.state_empty.*
import me.gilo.raison.ui.user.onboarding.SignUpActivity
import me.gilo.woodroid.app.R
import me.gilo.woodroid.app.adapter.CartAdapter
import me.gilo.woodroid.app.common.Status
import me.gilo.woodroid.app.events.AddQuantityEvent
import me.gilo.woodroid.app.events.LessQuantityEvent
import me.gilo.woodroid.app.models.CartLineItem
import me.gilo.woodroid.app.ui.WooDroidActivity
import me.gilo.woodroid.app.viewmodels.CartViewModel
import me.gilo.woodroid.models.Customer
import me.gilo.woodroid.models.LineItem
import me.gilo.woodroid.models.Order
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class CartActivity : WooDroidActivity<CartViewModel>() {


    override lateinit var viewModel: CartViewModel
    var cartItems: ArrayList<CartLineItem> = ArrayList()

    lateinit var adapter: CartAdapter
    lateinit var customer: Customer

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        setSupportActionBar(toolbar)

        viewModel = getViewModel(CartViewModel::class.java)
        title = "Cart"

        val layoutManager = LinearLayoutManager(
            baseContext,
            LinearLayoutManager.VERTICAL,
            false
        )
        rvCart.layoutManager = layoutManager
        rvCart.isNestedScrollingEnabled = false

        cartItems = ArrayList()

        adapter = CartAdapter(cartItems)
        rvCart.adapter = adapter

        cart()
        customer()

        llEmptyState_layout.visibility = View.GONE




    }

    override fun cart() {
        viewModel.cart().observe(this, androidx.lifecycle.Observer { response ->
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

                    llEmptyState_layout.visibility = View.VISIBLE
                }
            }

        })

    }


    private fun createOrder(order : Order) {
        viewModel.createOrder(order).observe(this, androidx.lifecycle.Observer { response ->
            when (response!!.status()) {
                Status.LOADING -> {
                    showLoading()
                }

                Status.SUCCESS -> {
                    finish()
                }

                Status.ERROR -> {
                    stopShowingLoading()

                    toast("Something went wrong!")
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
                cartitem.product.sale_price.replace(",","").toInt()
            }else{
                cartitem.product.regular_price.replace(",","").toInt()
            }

            var qty = cartitem.quantity

            total += price * qty

        }

        if (itemCount == 1){
            tvTotalItemCountTitle.text = "Item ($itemCount)"
        }else{
            tvTotalItemCountTitle.text = "Items ($itemCount)"
        }

        tvTotalItemCost.text = "Ksh$total"
        tvTotal.text = "Ksh$total"

        flSave.setOnClickListener{
            prepOrder()
        }
    }

    private fun prepOrder() {
        var order = Order()

        var lineitems  = ArrayList<LineItem>()

        for (cartitem in cartItems){
           var lineItem = LineItem()
            lineItem.price = cartitem.getPrice().toString()
            lineItem.productId = cartitem.productId
            lineItem.quantity = cartitem.quantity

            lineitems.add(lineItem)
        }

        order.lineItems = lineitems
        order.billingAddress = customer.billingAddress
        order.shippingAddress = customer.shippingAddress
        order.customer = customer

        createOrder(order)
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
        viewModel.setQuantity(cartLineItem, quantity).observe(this, androidx.lifecycle.Observer { response ->
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
        viewModel.deleteItem(cartLineItem).observe(this, androidx.lifecycle.Observer { response ->
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

    private fun customer() {
        viewModel.currentCustomer().observe(this, Observer {
                response->
            when (response!!.status()){
                Status.LOADING ->{

                }

                Status.SUCCESS ->{
                    customer = response.data()[0]

                }

                Status.ERROR ->{
                    Toast.makeText(baseContext, response.error().message.toString(), Toast.LENGTH_LONG).show()
                }

                Status.EMPTY ->{
                    startActivity(Intent(baseContext, SignUpActivity::class.java))
                    finish()
                }

            }
        })

    }


}

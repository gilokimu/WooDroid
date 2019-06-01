package me.gilo.woodroid.app.ui.order

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_order.*
import kotlinx.android.synthetic.main.content_order.*
import me.gilo.woodroid.app.R
import me.gilo.woodroid.app.adapter.CartAdapter
import me.gilo.woodroid.app.common.Status
import me.gilo.woodroid.app.models.CartLineItem
import me.gilo.woodroid.app.ui.WooDroidActivity
import me.gilo.woodroid.app.viewmodels.OrderViewModel
import me.gilo.woodroid.models.Order
import me.gilo.woodroid.models.filters.ProductFilter

class OrderActivity : WooDroidActivity<OrderViewModel>() {


    override lateinit var viewModel: OrderViewModel
    var orders: ArrayList<Order> = ArrayList()

    var cartItems: ArrayList<CartLineItem> = ArrayList()
    lateinit var adapter: CartAdapter

    var orderId = 0
    lateinit var order : Order

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        setSupportActionBar(toolbar)

        viewModel = getViewModel(OrderViewModel::class.java)
        title = "Orders"

        orderId = intent.getIntExtra("orderId", 0)

        val layoutManager = LinearLayoutManager(baseContext, LinearLayoutManager.VERTICAL, false)
        rvCart.layoutManager = layoutManager
        rvCart.isNestedScrollingEnabled = false

        cartItems = ArrayList()

        adapter = CartAdapter(cartItems)
        rvCart.adapter = adapter

        if(orderId != 0){
            order(orderId)
        }
    }

    private fun order(orderId : Int) {
        viewModel.order(orderId).observe(this, android.arch.lifecycle.Observer { response ->
            when (response!!.status()) {
                Status.LOADING -> {
                    showLoading()
                }

                Status.SUCCESS -> {
                    stopShowingLoading()

                    order = response.data()
                    var productIds  =  ArrayList<Int>()

                    for(orderLineItem in order.lineItems){
                        var cartLineItem = CartLineItem()
                        cartLineItem.name = orderLineItem.name
                        cartLineItem.price = orderLineItem.price.toFloat()
                        cartLineItem.quantity= orderLineItem.quantity
                        cartLineItem.productId = orderLineItem.productId

                        cartItems.add(cartLineItem)

                        productIds.add(orderLineItem.productId)
                    }

                    products(productIds.toIntArray())

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

    private fun products(productIds : IntArray) {
        var filter = ProductFilter()
        filter.setInclude(productIds)

        viewModel.products(filter).observe(this, android.arch.lifecycle.Observer { response ->
            when (response!!.status()) {
                Status.LOADING -> {
                    showLoading()
                }

                Status.SUCCESS -> {
                    stopShowingLoading()
                    var products = response.data()

                    var tempCartItems = ArrayList(cartItems)
                    cartItems.clear()

                    for (cartItem in tempCartItems){
                        var product = products.find { product -> product.id == cartItem.productId }
                        cartItem.product = product
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

    }

}

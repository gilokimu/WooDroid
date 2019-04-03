package me.gilo.wc.ui.product

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.text.Html
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_product.*
import kotlinx.android.synthetic.main.content_product.*
import me.gilo.wc.R
import me.gilo.wc.adapter.ImagePagerAdapter
import me.gilo.wc.common.BaseActivity
import me.gilo.wc.common.Status
import me.gilo.wc.events.ProductEvent
import me.gilo.wc.models.CartLineItem
import me.gilo.wc.ui.state.ProgressDialogFragment
import me.gilo.wc.viewmodels.ProductViewModel
import me.gilo.woodroid.models.Product
import org.greenrobot.eventbus.EventBus


class ProductActivity : BaseActivity() {

    var productInCart = false;
    lateinit var currentCartItem : CartLineItem

    lateinit var viewModel: ProductViewModel
    val TAG = this::getLocalClassName.toString()

    var related_ids : IntArray = intArrayOf()

    var cartItems : ArrayList<CartLineItem> = ArrayList()
    var productId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        setSupportActionBar(toolbar)

        viewModel = getViewModel(ProductViewModel::class.java)

        title = "Product"

        productId = intent.getIntExtra("productId", 0)

        if (productId != 0){
            product(productId)

        }

        cart()


    }


    private fun addToCart(productId: Int, price : Float) {
        viewModel.addToCart(productId, price).observe(this, android.arch.lifecycle.Observer { response ->
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

    private fun removeFromCart(cartLineItem: CartLineItem) {

        viewModel.deleteItem(cartLineItem).observe(this, android.arch.lifecycle.Observer { response ->
            when (response!!.status()) {
                Status.LOADING -> {

                }

                Status.SUCCESS -> {


                }

                Status.ERROR -> {
                    toast("error : " + response.error().message)
                }

                Status.EMPTY -> {

                }
            }

        })
    }


    private fun product(productId : Int) {
        viewModel.product(productId).observe(this, android.arch.lifecycle.Observer { response ->
            when (response!!.status()) {
                Status.LOADING -> {

                }

                Status.SUCCESS -> {
                    val product = response.data()
                    setUpPage(product)
                    //similarProducts(product)



                    EventBus.getDefault().post(ProductEvent(product))

                }

                Status.ERROR -> {

                }

                Status.EMPTY -> {

                }
            }

        })

    }


    private fun cart() {
        viewModel.cart().observe(this, android.arch.lifecycle.Observer { response ->
            when (response!!.status()) {
                Status.LOADING -> {

                }

                Status.SUCCESS -> {
                    cartItems.clear()
                    productInCart = false

                    for (cartItem in response.data()){
                        cartItems.add(cartItem)

                        if(cartItem.productId == productId){
                            productInCart = true
                            currentCartItem = cartItem


                        }
                    }

                    toggleFab()

                    if (cartItems.size == 0 && tvCartCounter != null){
                        tvCartCounter?.visibility = View.GONE
                    }else{
                        tvCartCounter?.visibility = View.VISIBLE
                        tvCartCounter?.text = cartItems.size.toString()
                    }


                }

                Status.ERROR -> {

                }

                Status.EMPTY -> {
                    productInCart = false
                    cartItems.clear()
                    toggleFab()

                    if (cartItems.size == 0 && tvCartCounter != null){
                        tvCartCounter?.visibility = View.GONE
                    }else{
                        tvCartCounter?.visibility = View.VISIBLE
                        tvCartCounter?.text = cartItems.size.toString()
                    }
                }
            }

        })

    }

    private fun toggleFab() {
        if (productInCart) {
            fab.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.carnation_red))
            fab.setImageDrawable(ContextCompat.getDrawable(baseContext, R.drawable.baseline_remove_shopping_cart_24))
        }else{
            fab.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.colorPrimary))
            fab.setImageDrawable(ContextCompat.getDrawable(baseContext, R.drawable.baseline_add_shopping_cart_24))
        }
    }


    private fun setUpPage(product: Product) {
        tvTitle.text = product.name
        tvDescription.text = Html.fromHtml(product.description)

        if (product.images != null && product.images.isNotEmpty()){
            vpImages.offscreenPageLimit = product.images.size
            vpImages.adapter = ImagePagerAdapter(baseContext, product.images)

            indicator.setViewPager(vpImages)
        }

        if (product.isOn_sale) {
           tvCallToAction.text = Html.fromHtml(product.price_html)

            tvOnSale.visibility = View.VISIBLE
        }else{
            tvCallToAction.text = Html.fromHtml(product.price_html).trim()
            tvOnSale.visibility = View.GONE
        }

        fab.setOnClickListener{
            if (productInCart){
                removeFromCart(currentCartItem)
            }else {
                addToCart(productId, product.price.toFloat())
            }
        }
    }

    fun toast(text : String){
        Toast.makeText(baseContext, text, Toast.LENGTH_LONG).show()
    }

    private lateinit var progressDialog: ProgressDialogFragment

    fun showLoading(title: String, message: String) {
        val manager = supportFragmentManager
        progressDialog = ProgressDialogFragment.newInstance(title, message)
        progressDialog.isCancelable = false
        progressDialog.show(manager, "progress")
    }

    fun showLoading() {
        showLoading("This will only take a sec", "Loading")
    }

    fun stopShowingLoading() {
        progressDialog.dismiss()
    }

    var tvCartCounter : TextView? = null

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(me.gilo.wc.R.menu.product, menu)

        val item = menu.findItem(me.gilo.wc.R.id.menu_cart)
        val rootView = item.actionView as FrameLayout
        tvCartCounter = rootView.findViewById<TextView>(me.gilo.wc.R.id.tvCart_counter)

        rootView.setOnClickListener{startActivity(Intent(baseContext, CartActivity::class.java))}

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_cart -> {

                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

}

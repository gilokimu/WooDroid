package me.gilo.woodroid.app.ui.product

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.text.Html
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_product.*
import kotlinx.android.synthetic.main.content_product.*
import me.gilo.woodroid.app.R
import me.gilo.woodroid.app.adapter.ImagePagerAdapter
import me.gilo.woodroid.app.common.BaseActivity
import me.gilo.woodroid.app.common.Status
import me.gilo.woodroid.app.events.ProductEvent
import me.gilo.woodroid.app.models.CartLineItem
import me.gilo.woodroid.app.ui.state.ProgressDialogFragment
import me.gilo.woodroid.app.viewmodels.ProductViewModel
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


    private fun addToCart(product: Product) {
        viewModel.addToCart(product.id).observe(this, androidx.lifecycle.Observer { response ->
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

        viewModel.deleteItem(cartLineItem).observe(this, androidx.lifecycle.Observer { response ->
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
        viewModel.product(productId).observe(this, androidx.lifecycle.Observer { response ->
            when (response!!.status()) {
                Status.LOADING -> {
                    flLoading.visibility = View.VISIBLE
                }

                Status.SUCCESS -> {
                    val product = response.data()
                    setUpPage(product)
                    //similarProducts(product)
                    flLoading.visibility = View.GONE


                    EventBus.getDefault().post(ProductEvent(product))

                }

                Status.ERROR -> {
                    flLoading.visibility = View.GONE
                }

                Status.EMPTY -> {
                }
            }

        })

    }


    private fun cart() {
        viewModel.cart().observe(this, androidx.lifecycle.Observer { response ->
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
                addToCart(product)
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
        menuInflater.inflate(R.menu.product, menu)

        val item = menu.findItem(R.id.menu_cart)
        val rootView = item.actionView as FrameLayout
        tvCartCounter = rootView.findViewById<TextView>(R.id.tvCart_counter)

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

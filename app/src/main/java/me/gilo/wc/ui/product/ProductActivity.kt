package me.gilo.wc.ui.product

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.text.Html
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_product.*
import kotlinx.android.synthetic.main.content_product.*
import kotlinx.android.synthetic.main.section_product_reviews.*
import me.gilo.wc.R
import me.gilo.wc.adapter.HomeProductAdapter
import me.gilo.wc.adapter.ImagePagerAdapter
import me.gilo.wc.adapter.ProductReviewAdapter
import me.gilo.wc.common.BaseActivity
import me.gilo.wc.common.Status
import me.gilo.wc.events.ProductEvent
import me.gilo.wc.ui.state.ProgressDialogFragment
import me.gilo.wc.viewmodels.ProductViewModel
import me.gilo.woodroid.models.Product
import me.gilo.woodroid.models.ProductReview
import org.greenrobot.eventbus.EventBus
import java.util.*

class ProductActivity : BaseActivity() {

    lateinit var viewModel: ProductViewModel
    val TAG = this::getLocalClassName.toString()

    var related_ids : IntArray = intArrayOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        setSupportActionBar(toolbar)

        viewModel = getViewModel(ProductViewModel::class.java)

        title = "Product"

        val productId = intent.getIntExtra("productId", 0)

        if (productId != 0){
            product(productId)
        }



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


    private fun product(productId : Int) {
        viewModel.product(productId).observe(this, android.arch.lifecycle.Observer { response ->
            when (response!!.status()) {
                Status.LOADING -> {

                }

                Status.SUCCESS -> {
                    val product = response.data()
                    setUpPage(product)
                    //similarProducts(product)

                    fab.setOnClickListener{addToCart(productId, product.price.toFloat())}

                    EventBus.getDefault().post(ProductEvent(product))

                }

                Status.ERROR -> {

                }

                Status.EMPTY -> {

                }
            }

        })

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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.home, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_filter -> {

                true
            }

            R.id.action_search -> {

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}

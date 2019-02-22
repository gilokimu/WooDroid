package me.gilo.wc.ui.product

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.text.Html
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import me.gilo.wc.R

import kotlinx.android.synthetic.main.activity_product.*
import kotlinx.android.synthetic.main.content_product.*
import me.gilo.wc.common.BaseActivity
import me.gilo.wc.common.Status
import me.gilo.wc.ui.state.ProgressDialogFragment
import me.gilo.wc.viewmodels.ProductViewModel
import me.gilo.woodroid.models.Product

class ProductActivity : BaseActivity() {

    lateinit var viewModel: ProductViewModel
    val TAG = this::getLocalClassName

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

    private fun product(productId : Int) {
        viewModel.product(productId).observe(this, android.arch.lifecycle.Observer { response ->
            when (response!!.status()) {
                Status.LOADING -> {

                }

                Status.SUCCESS -> {
                    val product = response.data()
                    setUpPage(product)

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
            Picasso.with(baseContext).load(product.images[0].src).into(ivImage)
        }

        if (product.isOn_sale) {
           tvCallToAction.text = Html.fromHtml(product.price_html)

            tvOnSale.visibility = View.VISIBLE
        }else{
            tvCallToAction.text = Html.fromHtml(product.price_html)
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

}

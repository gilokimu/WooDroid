package me.gilo.woodroid.app.ui.product

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.GridLayoutManager
import android.widget.Toast
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import me.gilo.woodroid.app.R

import kotlinx.android.synthetic.main.activity_product_search.*
import kotlinx.android.synthetic.main.content_shop.*
import me.gilo.woodroid.app.adapter.ProductAdapter
import me.gilo.woodroid.app.common.BaseActivity
import me.gilo.woodroid.app.common.Status
import me.gilo.woodroid.app.ui.state.ProgressDialogFragment
import me.gilo.woodroid.app.viewmodels.ProductViewModel
import me.gilo.woodroid.models.Product
import org.json.JSONObject
import java.util.ArrayList




class ProductSearchActivity : BaseActivity() {

    lateinit var adapter: ProductAdapter
    lateinit var products: ArrayList<Product>
    lateinit var toggle: ActionBarDrawerToggle

    lateinit var viewModel: ProductViewModel
    val TAG = this::getLocalClassName

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_search)
        setSupportActionBar(toolbar)

        viewModel = getViewModel(ProductViewModel::class.java)

        title = "Search"

        val layoutManager = GridLayoutManager(baseContext, 2)
        rvShop.layoutManager = layoutManager
        rvShop.isNestedScrollingEnabled = false

        products = ArrayList()

        adapter = ProductAdapter(products)
        rvShop.adapter = adapter

        handleIntent(intent)

    }

    override fun onNewIntent(intent: Intent) {
        handleIntent(intent)
    }

    private fun handleIntent(intent: Intent) {

        if (Intent.ACTION_SEARCH == intent.action) {
            val query = intent.getStringExtra(SearchManager.QUERY)
            search(query)
        }
    }

    private fun search(query : String) {
        viewModel.search(query).observe(this, android.arch.lifecycle.Observer { response ->
            when (response!!.status()) {
                Status.LOADING -> {
                    showLoading("Performing search", "This will only take a short while")
                }

                Status.SUCCESS -> {
                    stopShowingLoading()

                    val productsResponse = response.data()
                    for (product in productsResponse) {
                        products.add(product)
                    }

                    adapter.notifyDataSetChanged()

                }

                Status.ERROR -> {
                    stopShowingLoading()

                    var message: String
                    var loginError = JSONObject(response.error().message)

                    if (loginError.has("status_message")) {
                        message = loginError.getString("status_message")
                    } else {
                        message = response.error().message.toString()
                    }

                    Toast.makeText(baseContext, message, Toast.LENGTH_LONG).show()
                }

                Status.EMPTY -> {
                    stopShowingLoading()
                }
            }

        })



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

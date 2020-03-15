package me.gilo.woodroid.app.ui.product

import android.content.Context
import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.GridLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import kotlinx.android.synthetic.main.activity_shop.*
import kotlinx.android.synthetic.main.content_shop.*
import kotlinx.android.synthetic.main.drawer_filter.*
import me.gilo.woodroid.app.R
import me.gilo.woodroid.app.adapter.ProductAdapter
import me.gilo.woodroid.app.common.BaseActivity
import me.gilo.woodroid.app.common.Status
import me.gilo.woodroid.app.ui.state.ProgressDialogFragment
import me.gilo.woodroid.app.utils.AppUtils
import me.gilo.woodroid.app.viewmodels.ProductViewModel
import me.gilo.woodroid.models.Product
import me.gilo.woodroid.models.filters.ProductFilter
import java.util.*


class ShopActivity : BaseActivity() {

    lateinit var adapter: ProductAdapter
    var products : ArrayList<Product> = ArrayList()

    private lateinit var viewModel: ProductViewModel
    val TAG = this::getLocalClassName

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)
        setSupportActionBar(toolbar)

        viewModel = getViewModel(ProductViewModel::class.java)

        title = "Shop"


        setUpPage()



        cart()

        bFilter.setOnClickListener{filter()}

        if(intent.hasExtra("categoryId")){
            val filter = ProductFilter()
            filter.category = intent.getIntExtra("categoryId", 0)
            products(filter)

            title = intent.getStringExtra("name")
        }else{
            products()
        }
    }

    private fun setUpPage() {
        val layoutManager =
            GridLayoutManager(baseContext, 2)
        rvShop.layoutManager = layoutManager
        rvShop.isNestedScrollingEnabled = false

        products = ArrayList()

        adapter = ProductAdapter(products)
        rvShop.adapter = adapter
    }

    private fun filter() {
        val filter = ProductFilter()

        if (etSearch.text.toString().isNotEmpty()){
            filter.setSearch(etSearch.text.toString())
        }

        if (etMinPrice.text.toString().isNotEmpty()){
            filter.min_price = etMinPrice.text.toString()
        }

        if (etMaxPrice.text.toString().isNotEmpty()){
            filter.max_price = etMaxPrice.text.toString()
        }

        if (cbFeatured.isChecked){
            filter.isFeatured = true
        }

        if (cbOnSale.isChecked){
            filter.isOn_sale = true
        }

        toggleDrawer()

        products(filter)
    }

    private fun products(filter: ProductFilter) {
        viewModel.products(filter).observe(this, androidx.lifecycle.Observer { response ->
            when (response!!.status()) {
                Status.LOADING -> {
                }

                Status.SUCCESS -> {
                    products.clear()

                    val productsResponse = response.data()
                    for (product in productsResponse) {
                        products.add(product)
                    }

                    adapter.notifyDataSetChanged()

                }

                Status.ERROR -> {


                }

                Status.EMPTY -> {

                }
            }

        })
    }

    private fun cart() {
        val cartKey = AppUtils(baseContext).cartSession
    }

    private fun search(query : String) {
        viewModel.search(query).observe(this, androidx.lifecycle.Observer { response ->
            when (response!!.status()) {
                Status.LOADING -> {
                }

                Status.SUCCESS -> {
                    products.clear()

                    val productsResponse = response.data()
                    for (product in productsResponse) {
                        products.add(product)
                    }

                    adapter.notifyDataSetChanged()

                }

                Status.ERROR -> {


                }

                Status.EMPTY -> {

                }
            }

        })

    }

    private fun products() {
        viewModel.products().observe(this, androidx.lifecycle.Observer { response ->
            when (response!!.status()) {
                Status.LOADING -> {

                }

                Status.SUCCESS -> {
                    products.clear()
                    val productsResponse = response.data()
                    for (product in productsResponse) {
                        products.add(product)
                    }

                    adapter.notifyDataSetChanged()

                }

                Status.ERROR -> {

                }

                Status.EMPTY -> {

                }
            }

        })

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.products, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_filter -> {
                toggleDrawer()
                true
            }

            R.id.action_search -> {
                toggleDrawer()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun toast(text: String) {
        Toast.makeText(baseContext, text, Toast.LENGTH_LONG).show()
    }

    private fun toggleDrawer() {
        if (drawer_layout.isDrawerOpen(GravityCompat.END)) {
            drawer_layout.closeDrawer(GravityCompat.END)
        } else {
            drawer_layout.openDrawer(GravityCompat.END)
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

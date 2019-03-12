package me.gilo.wc.ui.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home.*
import me.gilo.wc.R
import me.gilo.wc.adapter.HomeProductAdapter
import me.gilo.wc.common.Status
import me.gilo.wc.viewmodels.ProductViewModel
import me.gilo.woodroid.models.Product
import me.gilo.woodroid.models.filters.ProductFilter
import java.util.*


class HomeFragment : Fragment() {


    lateinit var viewModel: ProductViewModel
    val TAG = "HomeFragment"

    lateinit var adapter: HomeProductAdapter
    private lateinit var products: ArrayList<Product>

    lateinit var hoodieAdapter: HomeProductAdapter
    private lateinit var hoodieProducts: ArrayList<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as HomeActivity).getViewModel(ProductViewModel::class.java)

        setUpProducts()
        setUpHoodies()

    }

    private fun setUpProducts() {
        val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        rvShop.layoutManager = layoutManager
        rvShop.isNestedScrollingEnabled = false

        products = ArrayList()

        adapter = HomeProductAdapter(products)
        rvShop.adapter = adapter

        products()
    }


    private fun setUpHoodies() {
        val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        rvHoodies.layoutManager = layoutManager
        rvHoodies.isNestedScrollingEnabled = false

        hoodieProducts = ArrayList()

        hoodieAdapter = HomeProductAdapter(hoodieProducts)
        rvHoodies.adapter = hoodieAdapter


        val filter = ProductFilter()
        filter.category = 21
        products(filter)
    }


    companion object {
        @JvmStatic
        fun newInstance() =
            HomeFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    private fun products() {
        viewModel.products().observe(this, android.arch.lifecycle.Observer { response ->
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

    private fun products(filter: ProductFilter) {
        viewModel.products(filter).observe(this, android.arch.lifecycle.Observer { response ->
            when (response!!.status()) {
                Status.LOADING -> {
                }

                Status.SUCCESS -> {
                    hoodieProducts.clear()

                    val productsResponse = response.data()
                    for (product in productsResponse) {
                        hoodieProducts.add(product)
                    }

                    hoodieAdapter.notifyDataSetChanged()

                }

                Status.ERROR -> {


                }

                Status.EMPTY -> {

                }
            }

        })
    }

}

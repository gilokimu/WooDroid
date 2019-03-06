package me.gilo.wc.ui.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_category.*
import me.gilo.wc.R
import me.gilo.wc.adapter.CategoryAdapter
import me.gilo.wc.common.Status
import me.gilo.wc.viewmodels.CategoryViewModel
import me.gilo.woodroid.models.Category
import java.util.*


class CategoryFragment : Fragment() {


    lateinit var viewModel: CategoryViewModel
    val TAG = "CategoryFragment"

    lateinit var adapter: CategoryAdapter
    lateinit var categories: ArrayList<Category>

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

        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as HomeActivity).getViewModel(CategoryViewModel::class.java)

        val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        rvCategory.layoutManager = layoutManager
        rvCategory.isNestedScrollingEnabled = false

        categories = ArrayList()

        adapter = CategoryAdapter(categories)
        rvCategory.adapter = adapter

        categories()

    }

    private fun categories() {
        viewModel.categories().observe(this, android.arch.lifecycle.Observer { response ->
            when (response!!.status()) {
                Status.LOADING -> {
                }

                Status.SUCCESS -> {
                    categories.clear()

                    val categoriesResponse = response.data()
                    for (category in categoriesResponse) {
                        categories.add(category)
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

    companion object {
        @JvmStatic
        fun newInstance() =
            CategoryFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

}

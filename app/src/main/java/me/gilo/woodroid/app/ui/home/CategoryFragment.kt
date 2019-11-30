package me.gilo.woodroid.app.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_category.*
import me.gilo.woodroid.app.R
import me.gilo.woodroid.app.adapter.CategoryAdapter
import me.gilo.woodroid.app.common.Status
import me.gilo.woodroid.app.viewmodels.CategoryViewModel
import me.gilo.woodroid.models.Category
import me.gilo.woodroid.models.filters.ProductCategoryFilter
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

        val layoutManager = LinearLayoutManager(
            activity,
            LinearLayoutManager.VERTICAL,
            false
        )
        rvCategory.layoutManager = layoutManager
        rvCategory.isNestedScrollingEnabled = false

        categories = ArrayList()

        adapter = CategoryAdapter(categories)
        rvCategory.adapter = adapter

        categories()

    }

    private fun categories() {

        val filter = ProductCategoryFilter()
        filter.setPer_page(50)

        viewModel.categories(filter).observe(this, androidx.lifecycle.Observer { response ->
            when (response!!.status()) {
                Status.LOADING -> {
                }

                Status.SUCCESS -> {
                    categories.clear()

                    val categoriesResponse = response.data()

                    for (category in categoriesResponse) {
                        if (category.name != "Uncategorized") {
                            categories.add(category)
                        }
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

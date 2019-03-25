package me.gilo.wc.ui.product.section

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.section_product_reviews.*
import me.gilo.wc.R
import me.gilo.wc.adapter.ProductReviewAdapter
import me.gilo.wc.common.BaseActivity
import me.gilo.wc.common.Status
import me.gilo.wc.events.ReviewEvent
import me.gilo.wc.ui.product.ProductActivity
import me.gilo.wc.viewmodels.ProductViewModel
import me.gilo.wc.viewmodels.ReviewViewModel
import me.gilo.woodroid.models.ProductReview
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.*


class ProductReviewsFragment : Fragment() {


    lateinit var viewModel: ReviewViewModel
    val TAG = "ProductReviewsFragment"
    var productId = 0

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

        return inflater.inflate(R.layout.section_product_reviews, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as BaseActivity).getViewModel(ReviewViewModel::class.java)


        productId = (activity as ProductActivity).intent.getIntExtra("productId", 0)
        reviews(productId)

        tvAddAReview.setOnClickListener{addAReviewDialog()}
    }

    private fun reviews(productId : Int) {

        val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        rvReviews.layoutManager = layoutManager
        rvReviews.isNestedScrollingEnabled = false

        var reviews = ArrayList<ProductReview>()

        var productReviewAdapter = ProductReviewAdapter(reviews)
        rvReviews.adapter = productReviewAdapter


        viewModel.reviews(productId).observe(this, android.arch.lifecycle.Observer { response ->
            when (response!!.status()) {
                Status.LOADING -> {

                }

                Status.SUCCESS -> {
                    reviews.clear()

                    val reviewsResponse = response.data()
                    for (review in reviewsResponse) {
                        reviews.add(review)
                    }

                    productReviewAdapter.notifyDataSetChanged()

                }

                Status.ERROR -> {
                    Log.d("Error", response.error().message)
                }

                Status.EMPTY -> {

                }
            }

        })

    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ProductReviewsFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    lateinit var addAReviewFragment: AddAReviewDialogFragment

    private fun addAReviewDialog() {
        val manager = childFragmentManager
        addAReviewFragment = AddAReviewDialogFragment.newInstance(productId)
        addAReviewFragment.isCancelable = true
        addAReviewFragment.show(manager, "add Review")
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(event: ReviewEvent) {
        save(event.review)
    }

    private fun save(review: ProductReview) {
        viewModel.create(review).observe(this, android.arch.lifecycle.Observer { response ->
            when (response!!.status()) {
                Status.LOADING -> {

                }

                Status.SUCCESS -> {
                    val reviewsResponse = response.data()
                   reviews(productId)

                }

                Status.ERROR -> {
                    Log.d("Error", response.error().message)
                }

                Status.EMPTY -> {

                }
            }

        })


    }

}

package me.gilo.wc.ui.product.section

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.section_add_a_review.*
import me.gilo.wc.R
import me.gilo.wc.events.ReviewEvent
import me.gilo.woodroid.models.ProductReview
import org.greenrobot.eventbus.EventBus


class AddAReviewDialogFragment : DialogFragment() {

    var productId = 0

    private val ARG_PRODUCT_ID = "productId"

    init {
        val args = Bundle()
        args.putInt(ARG_PRODUCT_ID, productId)

        arguments = args
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.section_add_a_review, container)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productId = arguments!!.getInt(ARG_PRODUCT_ID)

        llSave.setOnClickListener{save()}

    }

    private fun save() {
        var productReview = ProductReview()

        var review = etReview.text.toString()
        var rating = rbRating.rating
        var email = etEmail.text.toString()
        var name = etName.text.toString()

        productReview.product_id = productId
        productReview.rating = rating.toInt()
        productReview.review = review
        productReview.reviewer = name
        productReview.reviewer_email = email
        productReview.isVerified = true


        EventBus.getDefault().post(ReviewEvent(productReview))

        dismiss()

    }

    companion object {

        fun newInstance(productId : Int): AddAReviewDialogFragment {
            val fragment = AddAReviewDialogFragment()
            val args = Bundle()
            args.putInt("productId", productId)

            fragment.arguments = args
            return fragment
        }
    }
}
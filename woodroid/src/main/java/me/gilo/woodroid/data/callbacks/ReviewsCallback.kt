package me.gilo.woodroid.data.callbacks


import com.google.gson.annotations.SerializedName
import me.gilo.woodroid.models.ProductReview

import java.util.ArrayList


class ReviewsCallback {
    @SerializedName("product_reviews")
    lateinit var productReviews: ArrayList<ProductReview>
}

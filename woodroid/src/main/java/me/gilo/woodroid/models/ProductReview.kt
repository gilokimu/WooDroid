package me.gilo.woodroid.models

import java.io.Serializable
import java.util.Date


class ProductReview : Serializable {
    var id: Int = 0
    var date_created: Date? = null
    var date_created_gmt: Date? = null
    var product_id: Int = 0
    lateinit var reviewer: String
    lateinit var reviewer_email: String

    lateinit var reviewer_avatar_urls: Map<String, String>

    var review: String? = null
    var rating: Int = 0
    var isVerified: Boolean = false
}

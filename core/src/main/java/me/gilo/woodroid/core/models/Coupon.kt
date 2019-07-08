package me.gilo.woodroid.models

import java.io.Serializable

class Coupon : Serializable {

    var usage_limit: Int = 0
    var code: String? = null
    var free_shipping: String? = null
    var description: String? = null
    var minimum_amount: String? = null
    var email_restrictions: Array<String>? = null
    var exclude_sale_items: String? = null
    var excluded_product_ids: Array<String>? = null
    var usage_count: String? = null
    var individual_use: String? = null
    var usage_limit_per_user: Int = 0
    var limit_usage_to_x_items: Int = 0
    var meta_data: Array<String>? = null
    var id: Int = 0
    var date_modified_gmt: String? = null
    var amount: String? = null
    var date_created: String? = null
    var date_created_gmt: String? = null
    var maximum_amount: String? = null
    var discount_type: String? = null
    var used_by: Array<String>? = null
    var date_modified: String? = null
    var product_ids: Array<String>? = null
    var product_categories: Array<String>? = null
    var date_expires: String? = null
    var excluded_product_categories: Array<String>? = null
    var date_expires_gmt: String? = null
}

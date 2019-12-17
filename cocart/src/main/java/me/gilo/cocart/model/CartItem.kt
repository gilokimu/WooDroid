package me.gilo.cocart.model

import com.google.gson.annotations.SerializedName


class CartItem {

    @SerializedName("product_id")
    var productId: Int = 0

    @SerializedName("variation_id")
    var variationId: Int? = null

    var variation: Array<Any>? = null

    lateinit var subtotal: String
    @SerializedName("subtotal_tax")
    lateinit var subtotalTax: String
    lateinit var total: String
    lateinit var totalTax: String
    lateinit var price: String
    var quantity: Int = 0
    lateinit var taxClass: Any
    lateinit var name: String


    lateinit var key: String
    lateinit var sku: String
    lateinit var variations: String
    lateinit var data_hash: String
}

package me.gilo.woodroid.models

import com.google.gson.annotations.SerializedName

import java.util.ArrayList


class LineItem {

    lateinit var subtotal: String
    @SerializedName("subtotal_tax")
    lateinit var subtotalTax: String
    lateinit var total: String
    lateinit var totalTax: String
    lateinit var price: String
    var quantity: Int = 0
    lateinit var taxClass: Any
    lateinit var name: String

    @SerializedName("product_id")
    var productId: Int = 0

    lateinit var sku: String
    lateinit var variations: String
    var meta: List<Metum> = ArrayList()
}

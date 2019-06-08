package me.gilo.woodroid.models

import com.google.gson.annotations.SerializedName

import java.util.ArrayList


class LineItem {

    var subtotal: String
    @SerializedName("subtotal_tax")
    var subtotalTax: String
    var total: String
    var totalTax: String
    var price: String
    var quantity: Int = 0
    var taxClass: Any
    var name: String

    @SerializedName("product_id")
    var productId: Int = 0

    var sku: String
    var variations: String
    var meta: List<Metum> = ArrayList()
}

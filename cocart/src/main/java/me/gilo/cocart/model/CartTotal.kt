package me.gilo.cocart.model

import com.google.gson.annotations.SerializedName


data class CartTotal (

    @SerializedName("subtotal")
    var subtotal: String? = "",

    @SerializedName("subtotal_tax")
    var subtotalTax: Float? = 0f,

    @SerializedName("shipping_total")
    var shippingTotal: String? = "",

    @SerializedName("shipping_tax")
    var shippingTax: Float? = 0f,

    @SerializedName("shipping_taxes")
    var shippingTaxes: Map<String, Float>? = HashMap(),

    @SerializedName("discount_total")
    var discountTotal: Float? = 0f,

    @SerializedName("discount_tax")
    var discountTax: Float? = 0f,

    @SerializedName("cart_contents_total")
    var cartContentsTotal: String? = "",

    @SerializedName("cart_contents_tax")
    var cartContentsTax:  Float? = 0f,

    @SerializedName("cart_contents_taxes")
    var cartContentsTaxes: Map<String, Float>? = HashMap(),

    @SerializedName("fee_total")
    var feeTotal: String? = "",

    @SerializedName("fee_tax")
    var feeTax: String? = "",

    @SerializedName("fee_taxes")
    var feeTaxes: Any,

    @SerializedName("total")
    var total: String? = "",

    @SerializedName("total_tax")
    var totalTax:  Float? = 0f


    )

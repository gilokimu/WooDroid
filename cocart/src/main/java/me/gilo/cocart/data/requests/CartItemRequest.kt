package me.gilo.cocart.data.requests

import com.google.gson.annotations.SerializedName

data class CartItemRequest(
    @SerializedName("product_id")
    var productId: Int,

    @SerializedName("quantity")
    var quantity: Int,

    @SerializedName("variation_id")
    var variationId: Int? = null,

    @SerializedName("variation")
    var variation: Any? = null,

    @SerializedName("cart_item_data")
    var cartItemData: Any? = null,

    @SerializedName("refresh_totals")
    var refreshTotals: Boolean? = null,

    @SerializedName("return_cart")
    var returnCart: Boolean? = null
)
package me.gilo.woodroid.models

import com.google.gson.annotations.SerializedName


class ShippingLine {
    @SerializedName("method_id")
    var id: String? = null
    @SerializedName("method_title")
    var methodTitle: String? = null
    var total: Int = 0
}

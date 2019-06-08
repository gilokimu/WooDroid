package me.gilo.woodroid.models

import com.google.gson.annotations.SerializedName


class PaymentDetails {
    @SerializedName("method_id")
    var methodId: String
    @SerializedName("method_title")
    var methodTitle: String
    var paid: Boolean? = null
}

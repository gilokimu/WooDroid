package me.gilo.cocart.data.requests

import com.google.gson.annotations.SerializedName

data class CartRequest(
    @SerializedName("id")
    var customerId: String? = null,

    @SerializedName("thumb")
    var thumb: Boolean?
)
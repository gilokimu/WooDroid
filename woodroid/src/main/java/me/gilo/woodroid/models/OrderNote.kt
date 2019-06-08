package me.gilo.woodroid.models

import com.google.gson.annotations.SerializedName

import java.util.ArrayList


class OrderNote {
    var id: Int = 0
    var author: String
    var date_created: String
    var date_created_gmt: String
    var note: String
    var isCustomer_note: Boolean = false
}

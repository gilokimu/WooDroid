package me.gilo.woodroid.models

import com.google.gson.annotations.SerializedName

import java.util.ArrayList


class OrderNote {
    var id: Int = 0
    lateinit var author: String
    lateinit var date_created: String
    lateinit var date_created_gmt: String
    lateinit var note: String
    var isCustomer_note: Boolean = false
}

package me.gilo.woodroid.models

import com.google.gson.annotations.SerializedName

class ShippingClass {
    var id: Int = 0
    lateinit var name: String
    lateinit var slug: String
    lateinit var description: String
    var count: Int = 0
}

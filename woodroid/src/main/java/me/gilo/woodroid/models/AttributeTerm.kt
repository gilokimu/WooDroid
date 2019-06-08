package me.gilo.woodroid.models

import android.os.Parcel

import java.io.Serializable


class AttributeTerm : Serializable {
    var id: Int = 0
    var name: String? = null
    var slug: String? = null
    lateinit var description: String
    var menu_order: Int = 0
    var count: Int = 0
}

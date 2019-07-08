package me.gilo.woodroid.models

import android.os.Parcel

import java.io.Serializable


class Dimension protected constructor(`in`: Parcel) : Serializable {

    var length: String? = null
    var width: String? = null
    var height: String? = null
    var unit: String? = null

    init {
        length = `in`.readString()
        width = `in`.readString()
        height = `in`.readString()
        unit = `in`.readString()
    }

}

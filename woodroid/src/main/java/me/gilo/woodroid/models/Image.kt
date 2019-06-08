package me.gilo.woodroid.models

import android.os.Parcel

import java.io.Serializable
import java.util.Date

class Image : Serializable {
    var id: Int = 0
    var date_created: String? = null
    var date_created_gmt: String? = null
    var date_modified: String? = null
    var date_modified_gmt: String? = null
    var src: String? = null
    var name: String? = null
    var alt: String? = null
    var position: Int = 0
}

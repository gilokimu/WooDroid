package me.gilo.woodroid.models

import java.io.Serializable

class ProductAttribute : Serializable {
    var id: Int = 0
    var name: String? = null
    var slug: String? = null
    var type: String? = null
    var position: Int = 0
    var isVisible: Boolean = false
    var isVariation: Boolean = false
    var options: Array<String>? = null
}

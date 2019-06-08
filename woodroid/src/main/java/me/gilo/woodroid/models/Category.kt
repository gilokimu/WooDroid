package me.gilo.woodroid.models

import java.io.Serializable

class Category : Serializable {
    var id: Int = 0
    var name: String? = null
    var slug: String? = null
    var parent: Int = 0
    lateinit var description: String
    lateinit var display: String
    lateinit var image: Image
    var menu_order: Int = 0
    var count: Int = 0
}

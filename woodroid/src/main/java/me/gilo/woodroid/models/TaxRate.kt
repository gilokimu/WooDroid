package me.gilo.woodroid.models

class TaxRate {
    var id: Int = 0
    var country: String? = null
    var city: String? = null
    var postcode: String? = null
    var priority: Int = 0
    var isCompound: Boolean = false
    var isShipping: Boolean = false
    var rate: String? = null
    var name: String? = null
    var state: String? = null
    var order: Int = 0
}

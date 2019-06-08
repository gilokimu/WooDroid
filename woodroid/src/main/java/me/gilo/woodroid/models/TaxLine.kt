package me.gilo.woodroid.models


class TaxLine {
    var id: Int = 0
    var rate_id: Int = 0
    var code: String? = null
    var title: String? = null
    var total: Double = 0.toDouble()
    var isCompound: Boolean = false
}

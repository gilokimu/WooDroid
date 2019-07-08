package me.gilo.woodroid.core.cart.lines


class LineItem(
    var subtotal: Float = 0f,
    var subtotalTax: Float = 0f,
    var total: Float = 0f,
    var totalTax: Float = 0f,
    var price: Float = 0f,
    var quantity: Int = 0,
    var taxClass: Any,
    var name: String = "",
    var productId: Int = 0,

    var sku: String = "",
    var variations: String = "",
    var meta: List<Metum> = ArrayList()
)

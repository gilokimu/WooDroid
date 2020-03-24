package me.gilo.woodroid.core.cart


import androidx.lifecycle.LiveData
import me.gilo.woodroid.core.cart.lines.FeeLine
import me.gilo.woodroid.core.cart.lines.LineItem
import me.gilo.woodroid.core.cart.lines.ShippingLine
import me.gilo.woodroid.models.TaxLine
import java.util.ArrayList
import java.util.Date


data class Cart(
    var id: Int = 0,
    var dateCreated: Date = Date(),
    var dateUpdate: Date = Date(),
    var completedAt: Date = Date(),

    var currency: String = "USD",

    var total: Float = 0f,
    var subtotal: Float = 0f,
    var totalLineItemsQuantity: Float = 0f,
    var totalTax: Float = 0f,
    var totalShipping: Float = 0f,
    var cartTax: Float = 0f,
    var shippingTax: Float = 0f,
    var totalDiscount: Float = 0f,
    var lineItems: MutableList<LineItem> = ArrayList(),
    var shippingLines: List<ShippingLine> = ArrayList(),

    var taxLines: List<TaxLine> = ArrayList(),

    var feeLines: List<FeeLine> = ArrayList(),

    var couponLines: List<Any> = ArrayList(),
    var items: LiveData<List<CartItem>>

)

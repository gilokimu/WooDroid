package me.gilo.woodroid.models

import com.google.gson.annotations.SerializedName

import java.util.ArrayList
import java.util.Date


class Order {
    var id: Int = 0
    @SerializedName("number")
    lateinit var orderNumber: String
    @SerializedName("created_at")
    lateinit var createdAt: String

    @SerializedName("date_created")
    lateinit var dateCreated: Date

    @SerializedName("updated_at")
    lateinit var updatedAt: String
    @SerializedName("completed_at")
    lateinit var completedAt: String
    lateinit var status: String
    lateinit var currency: String
    lateinit var total: String
    lateinit var subtotal: String
    @SerializedName("total_line_items_quantity")
    var totalLineItemsQuantity: Int = 0
    @SerializedName("total_tax")
    lateinit var totalTax: String
    @SerializedName("total_shipping")
    lateinit var totalShipping: String
    @SerializedName("cart_tax")
    lateinit var cartTax: String
    @SerializedName("shipping_tax")
    lateinit var shippingTax: String
    @SerializedName("total_discount")
    lateinit var totalDiscount: String
    @SerializedName("shipping_methods")
    lateinit var shippingMethods: String
    @SerializedName("payment_details")
    lateinit var paymentDetails: PaymentDetails
    @SerializedName("billing")
    lateinit var billingAddress: BillingAddress
    @SerializedName("shipping")
    lateinit var shippingAddress: ShippingAddress
    lateinit var note: String
    @SerializedName("customer_ip")
    lateinit var customerIp: String
    @SerializedName("customer_user_agent")
    lateinit var customerUserAgent: String
    @SerializedName("customer_id")
    var customerId: Int? = null
    @SerializedName("view_order_url")
    lateinit var viewOrderUrl: String
    @SerializedName("line_items")
    var lineItems: MutableList<LineItem> = ArrayList()
    @SerializedName("shipping_lines")
    var shippingLines: List<ShippingLine> = ArrayList()
    @SerializedName("tax_lines")
    var taxLines: List<TaxLine> = ArrayList()
    @SerializedName("fee_lines")
    var feeLines: List<FeeLine> = ArrayList()
    @SerializedName("coupon_lines")
    var couponLines: List<Any> = ArrayList()
    lateinit var customer: Customer


    fun addLineItem(lineItem: LineItem) {
        lineItems.add(lineItem)

    }
}

package me.gilo.woodroid.firebasecart.models

import com.google.gson.annotations.SerializedName
import me.gilo.woodroid.models.BillingAddress
import me.gilo.woodroid.models.ShippingAddress

import java.io.Serializable


class Customer : Serializable {
    var id: Int = 0

    @SerializedName("created_at")
    lateinit var createdAt: String

    lateinit var email: String

    @SerializedName("first_name")
    lateinit var firstName: String

    @SerializedName("last_name")
    lateinit var lastName: String

    lateinit var username: String
    lateinit var password: String
    lateinit var role: String

    @SerializedName("last_order_id")
    lateinit var lastOrderId: String

    @SerializedName("last_order_date")
    lateinit var lastOrderDate: String

    @SerializedName("orders_count")
    var ordersCount: Int = 0

    @SerializedName("total_spent")
    lateinit var totalSpent: String

    @SerializedName("avatar_url")
    lateinit var avatarUrl: String

    @SerializedName("billing")
    lateinit var billingAddress: BillingAddress

    @SerializedName("shipping")
    lateinit var shippingAddress: ShippingAddress


}

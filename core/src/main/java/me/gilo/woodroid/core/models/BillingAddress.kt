package me.gilo.woodroid.models

import com.google.gson.annotations.SerializedName

import java.io.Serializable

class BillingAddress : Serializable {
    var id: Int = 0
    @SerializedName("first_name")
    lateinit var firstName: String
    @SerializedName("last_name")
    lateinit var lastName: String
    lateinit var company: String
    @SerializedName("address_1")
    lateinit var address1: String
    @SerializedName("address_2")
    lateinit var address2: String
    lateinit var city: String
    lateinit var state: String
    lateinit var postcode: String
    lateinit var country: String
    lateinit var email: String
    lateinit var phone: String

    override fun toString(): String {
        return (firstName + " " + lastName + "\n"
                + address1 + " " + address2 + "\n"
                + city + ", " + state + " " + postcode + "\n"
                + country + "\n"
                + phone)
    }
}

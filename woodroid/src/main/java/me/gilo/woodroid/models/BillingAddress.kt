package me.gilo.woodroid.models

import com.google.gson.annotations.SerializedName

import java.io.Serializable

class BillingAddress : Serializable {
    var id: Int = 0
    @SerializedName("first_name")
    var firstName: String
    @SerializedName("last_name")
    var lastName: String
    var company: String
    @SerializedName("address_1")
    var address1: String
    @SerializedName("address_2")
    var address2: String
    var city: String
    var state: String
    var postcode: String
    var country: String
    var email: String
    var phone: String

    override fun toString(): String {
        return (firstName + " " + lastName + "\n"
                + address1 + " " + address2 + "\n"
                + city + ", " + state + " " + postcode + "\n"
                + country + "\n"
                + phone)
    }
}

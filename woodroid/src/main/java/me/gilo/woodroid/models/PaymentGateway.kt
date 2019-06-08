package me.gilo.woodroid.models

class PaymentGateway {

    lateinit var id: String
    lateinit var title: String
    lateinit var description: String
    var order: Int = 0
    var isEnabled: Boolean = false
    lateinit var method_title: String
    lateinit var method_description: String
    lateinit var method_supports: Array<String>
    lateinit var settings: Map<String, PaymentGatewaySetting>
}

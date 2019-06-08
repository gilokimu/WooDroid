package me.gilo.woodroid.models

class PaymentGateway {

    var id: String
    var title: String
    var description: String
    var order: Int = 0
    var isEnabled: Boolean = false
    var method_title: String
    var method_description: String
    var method_supports: Array<String>
    var settings: Map<String, PaymentGatewaySetting>
}

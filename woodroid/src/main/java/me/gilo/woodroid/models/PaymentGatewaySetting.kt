package me.gilo.woodroid.models

import com.fasterxml.jackson.annotation.JsonProperty

class PaymentGatewaySetting {

    var id: String
    var label: String
    var description: String
    var type: String
    var value: String
    @JsonProperty("default")
    var default_value: String
    var tip: String
    var placeholder: String
}

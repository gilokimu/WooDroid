package me.gilo.woodroid.models

import com.fasterxml.jackson.annotation.JsonProperty

class SettingOption {

    var id: String
    var label: String
    var description: String
    var value: String

    @JsonProperty("default")
    var default_value: String
    var tip: String
    var placeholder: String
    var type: String
    var options: Map<String, String>
    var group_id: String
}

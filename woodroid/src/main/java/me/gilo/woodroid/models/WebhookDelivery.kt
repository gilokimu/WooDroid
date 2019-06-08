package me.gilo.woodroid.models

import java.util.Date

class WebhookDelivery {

    var id: Int = 0
    var duration: String
    var summary: String
    var request_url: String
    var request_headers: Map<String, String>
    var request_body: String
    var response_code: String
    var response_message: String
    var response_headers: Map<String, String>
    var response_body: String
    var date_created: Date
    var date_created_gmt: Date
}

package me.gilo.woodroid.models

import java.util.Date

class WebhookDelivery {

    var id: Int = 0
    lateinit var duration: String
    lateinit var summary: String
    lateinit var request_url: String
    lateinit var request_headers: Map<String, String>
    lateinit var request_body: String
    lateinit var response_code: String
    lateinit var response_message: String
    lateinit var response_headers: Map<String, String>
    lateinit var response_body: String
    lateinit var date_created: Date
    lateinit var date_created_gmt: Date
}

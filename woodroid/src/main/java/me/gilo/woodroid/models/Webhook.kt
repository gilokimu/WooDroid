package me.gilo.woodroid.models

import java.util.Date

class Webhook {
    var id: Int = 0
    var name: String
    var status: String
    var topic: String
    var resource: String
    var event: String
    var hooks: Array<String>
    var delivery_url: String
    var secret: String
    var date_created: Date
    var date_created_gmt: Date
    var date_modified: Date
    var date_modified_gmt: Date
}

package me.gilo.woodroid.models.report

class SalesTotal {

    var total_discount: Int = 0
    var net_sales: String? = null
    var total_customers: String? = null
    var totals: Map<String, SalesPeriodTotal>? = null
    var total_orders: Int = 0
    var total_tax: String? = null
    var total_items: Int = 0
    var totals_grouped_by: String? = null
    var total_shipping: String? = null
    var average_sales: String? = null
    var total_sales: String? = null
    var total_refunds: Int = 0
}

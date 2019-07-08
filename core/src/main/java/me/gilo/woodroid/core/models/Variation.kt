package me.gilo.woodroid.models

import java.util.ArrayList
import java.util.Date

class Variation {

    var id: Int = 0
    internal lateinit var title: String
    internal lateinit var name: String
    lateinit var slug: String
    lateinit var permalink: String
    lateinit var type: String
    lateinit var status: String
    var isFeatured: Boolean = false
    lateinit var catalog_visibility: String
    lateinit var description: String
    lateinit var short_description: String
    lateinit var sku: String
    lateinit var price: String
    lateinit var regular_price: String
    lateinit var sale_price: String
    lateinit var date_on_sale_from: Date
    lateinit var date_on_sale_from_gmt: Date
    lateinit var date_on_sale_to: Date
    lateinit var date_on_sale_to_gmt: Date
    lateinit var price_html: String
    var isOn_sale: Boolean = false
    var isPurchasable: Boolean = false
    var total_sales: Int = 0
    var isVirtual: Boolean = false
    var isDownloadable: Boolean = false
    lateinit var downloads: ArrayList<Download>
    var download_limit: Int = 0
    var download_expiry: Int = 0
    lateinit var external_url: String
    lateinit var button_text: String
    lateinit var tax_status: String
    lateinit var tax_class: String
    var isManage_stock: Boolean = false
    var stock_quantity: Int = 0
    var isIn_stock: Boolean = false
    lateinit var backorders: String
    var isBackorders_allowed: Boolean = false
    var isBackordered: Boolean = false
    var isSold_individually: Boolean = false
    lateinit var weight: String
    lateinit var dimensions: Any
    var isShipping_required: Boolean = false
    var isShipping_taxable: Boolean = false
    lateinit var shipping_class: String
    var shipping_class_id: Int = 0
    var isReviews_allowed: Boolean = false
    lateinit var average_rating: String
    var rating_count: Int = 0
    lateinit var related_ids: ArrayList<Int>
    lateinit var upsell_ids: ArrayList<Int>
    lateinit var cross_sell_ids: ArrayList<Int>
    var parent_id: Int = 0
    lateinit var purchase_note: String
    lateinit var categories: ArrayList<Category>
    lateinit var tags: ArrayList<Tag>
    lateinit var productAttributes: ArrayList<ProductAttribute>
    lateinit var default_attributes: ArrayList<DefaultAttribute>
    lateinit var grouped_products: ArrayList<Int>
    var menu_order: Int = 0
    lateinit var meta_data: ArrayList<Metadata>
    lateinit var images: ArrayList<Image>

    fun getTitle(): String {
        return name
    }

    fun setTitle(title: String) {
        this.title = title
    }

    fun getName(): String {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

}

package me.gilo.woodroid.models

import java.io.Serializable
import java.util.ArrayList
import java.util.Date


class Product : Serializable {

    var id: Int = 0
    var name: String
    var slug: String? = null
    var permalink: String? = null
    var type: String? = null
    var status: String
    var isFeatured: Boolean = false
    var catalog_visibility: String
    var description: String
    var short_description: String
    var sku: String
    var price: String
    var regular_price: String
    var sale_price: String
    var date_on_sale_from: Date
    var date_on_sale_from_gmt: Date
    var date_on_sale_to: Date
    var date_on_sale_to_gmt: Date
    var price_html: String
    var isOn_sale: Boolean = false
    var isPurchasable: Boolean = false
    var total_sales: Int = 0
    var isVirtual: Boolean = false
    var isDownloadable: Boolean = false
    var downloads: ArrayList<Download>
    var download_limit: Int = 0
    var download_expiry: Int = 0
    var external_url: String
    var button_text: String
    var tax_status: String
    var tax_class: String
    var isManage_stock: Boolean = false
    var stock_quantity: Int = 0
    var isIn_stock: Boolean = false
    var backorders: String
    var isBackorders_allowed: Boolean = false
    var isBackordered: Boolean = false
    var isSold_individually: Boolean = false
    var weight: String
    var dimensions: Any
    var isShipping_required: Boolean = false
    var isShipping_taxable: Boolean = false
    var shipping_class: String
    var shipping_class_id: Int = 0
    var isReviews_allowed: Boolean = false
    var average_rating: String
    var rating_count: Int = 0
    var related_ids: ArrayList<Int>
    var upsell_ids: ArrayList<Int>
    var cross_sell_ids: ArrayList<Int>
    var parent_id: Int = 0
    var purchase_note: String
    var categories: ArrayList<Category>
    var tags: ArrayList<Tag>
    var attributes: ArrayList<Attribute>
    var default_attributes: ArrayList<DefaultAttribute>
    var variations: ArrayList<Int>
    var grouped_products: ArrayList<Int>
    var menu_order: Int = 0
    var meta_data: ArrayList<Metadata>
    var images: ArrayList<Image>
}



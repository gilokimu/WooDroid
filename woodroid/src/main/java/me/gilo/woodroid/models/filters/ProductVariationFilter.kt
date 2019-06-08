package me.gilo.woodroid.models.filters

class ProductVariationFilter : ListFilter() {
    var parent: IntArray? = null
        set(parent) {
            field = parent

            if (parent != null) {
                addFilter("parent", parent)
            }

        }
    var parent_exclude: IntArray? = null
        set(parent_exclude) {
            field = parent_exclude

            if (parent_exclude != null) {
                addFilter("parent_exclude", parent_exclude)
            }

        }
    var slug: String? = null
        set(slug) {
            field = slug

            if (slug != null) {
                addFilter("slug", slug)
            }

        }
    var status: String? = null
        set(status) {
            field = status

            if (status != null) {
                addFilter("status", status)
            }

        }
    var type: String? = null
        set(type) {
            field = type

            if (type != null) {
                addFilter("type", type)
            }
        }
    var sku: String? = null
        set(sku) {
            field = sku

            if (sku != null) {
                addFilter("sku", sku)
            }
        }
    var isFeatured: Boolean = false
        set(featured) {
            field = featured

            addFilter("featured", featured)
        }
    var category: String? = null
        set(category) {
            field = category

            if (category != null) {
                addFilter("category", category)
            }
        }
    var tag: String? = null
        set(tag) {
            field = tag

            if (tag != null) {
                addFilter("tag", tag)
            }
        }
    var shipping_class: String? = null
        set(shipping_class) {
            field = shipping_class

            if (shipping_class != null) {
                addFilter("shipping_class", shipping_class)
            }
        }
    var attribute: String? = null
        set(attribute) {
            field = attribute

            if (attribute != null) {
                addFilter("attribute", attribute)
            }
        }
    var attribute_term: String? = null
        set(attribute_term) {
            field = attribute_term

            if (attribute_term != null) {
                addFilter("attribute_term", attribute_term)
            }
        }
    var tax_class: String? = null
        set(tax_class) {
            field = tax_class

            if (tax_class != null) {
                addFilter("tax_class", tax_class)
            }
        }
    var isOn_sale: Boolean = false
        set(on_sale) {
            field = on_sale

            addFilter("on_sale", on_sale)
        }
    var min_price: String? = null
        set(min_price) {
            field = min_price

            if (min_price != null) {
                addFilter("min_price", min_price)
            }
        }
    var max_price: String? = null
        set(max_price) {
            field = max_price

            if (max_price != null) {
                addFilter("max_price", max_price)
            }
        }
    var stock_status: String? = null
        set(stock_status) {
            field = stock_status

            if (stock_status != null) {
                addFilter("stock_status", stock_status)
            }
        }
}

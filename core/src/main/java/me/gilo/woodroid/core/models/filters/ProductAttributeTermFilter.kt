package me.gilo.woodroid.models.filters

class ProductAttributeTermFilter : ListFilter() {
    internal var product: Int = 0
    internal var hide_empty: Boolean = false
    internal lateinit var slug: String

    var isHide_empty: Boolean
        get() = hide_empty
        set(hide_empty) {
            this.hide_empty = hide_empty
            addFilter("hide_empty", hide_empty)
        }

    fun getProduct(): Int {
        return product
    }

    fun setProduct(product: Int) {
        this.product = product
        addFilter("product", product)
    }

    fun getSlug(): String {
        return slug
    }

    fun setSlug(slug: String) {
        this.slug = slug
        addFilter("slug", slug)
    }
}

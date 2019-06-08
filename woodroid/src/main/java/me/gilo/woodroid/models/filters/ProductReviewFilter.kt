package me.gilo.woodroid.models.filters

class ProductReviewFilter : ListFilter() {

    internal lateinit var reviewer: IntArray
    internal lateinit var reviewer_exclude: IntArray
    internal lateinit var reviewer_email: Array<String>

    internal lateinit var product: IntArray
    internal lateinit var status: String

    fun getReviewer(): IntArray {
        return reviewer
    }

    fun setReviewer(reviewer: IntArray) {
        this.reviewer = reviewer

        addFilter("reviewer", reviewer)
    }

    fun getReviewer_exclude(): IntArray {
        return reviewer_exclude
    }

    fun setReviewer_exclude(reviewer_exclude: IntArray) {
        this.reviewer_exclude = reviewer_exclude

        addFilter("reviewer_exclude", reviewer_exclude)
    }

    fun getReviewer_email(): Array<String> {
        return reviewer_email
    }

    fun setReviewer_email(reviewer_email: Array<String>) {
        this.reviewer_email = reviewer_email

        addFilter("reviewer_email", reviewer_email)
    }

    fun getProduct(): IntArray {
        return product
    }

    fun setProduct(product: IntArray) {
        this.product = product

        addFilter("product", product)
    }

    fun getStatus(): String {
        return status
    }

    fun setStatus(status: String) {
        this.status = status

        addFilter("status", status)
    }
}

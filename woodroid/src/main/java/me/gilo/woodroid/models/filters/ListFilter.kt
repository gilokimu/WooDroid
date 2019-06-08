package me.gilo.woodroid.models.filters

import me.gilo.woodroid.utils.Converter

import java.util.*

open class ListFilter {

    internal lateinit var context: String
    internal var page: Int = 0
    internal var per_page: Int = 0
    internal lateinit var search: String
    internal lateinit var after: String
    internal lateinit var before: String
    internal lateinit var exclude: IntArray
    internal lateinit var include: IntArray
    internal var offset: Int = 0
    internal lateinit var order: String
    internal lateinit var orderby: String


    internal var filters: MutableMap<String, String> = HashMap()

    fun getContext(): String {
        return context
    }

    fun setContext(context: String) {
        this.context = context

        addFilter("context", context)
    }

    fun getPage(): Int {
        return page
    }

    fun setPage(page: Int) {
        this.page = page

        addFilter("page", page)
    }

    fun getPer_page(): Int {
        return per_page
    }

    fun setPer_page(per_page: Int) {
        this.per_page = per_page

        addFilter("per_page", per_page)
    }

    fun getSearch(): String {
        return search
    }

    fun setSearch(search: String) {
        this.search = search

        addFilter("search", search)
    }

    fun getAfter(): String {
        return after
    }

    fun setAfter(after: String) {
        this.after = after

        addFilter("after", after)
    }

    fun getBefore(): String {
        return before
    }

    fun setAfter(date: Date) {
        setAfter(Converter.getDateString(date))
    }

    fun setBefore(date: Date) {
        setBefore(Converter.getDateString(date))
    }

    fun setBefore(before: String) {
        this.before = before

        addFilter("before", before)
    }

    fun getExclude(): IntArray {
        return exclude
    }

    fun setExclude(exclude: IntArray) {
        this.exclude = exclude

        addFilter("exclude", exclude)
    }

    fun getInclude(): IntArray {
        return include
    }

    fun setInclude(include: IntArray) {
        this.include = include

        addFilter("include", include)
    }

    fun getOffset(): Int {
        return offset
    }

    fun setOffset(offset: Int) {
        this.offset = offset

        addFilter("offset", offset)
    }

    fun getOrder(): String {
        return order
    }

    fun setOrder(order: String) {
        this.order = order

        addFilter("order", order)
    }

    fun setOrder(order: Sort) {
        setOrder(order.toString())
    }

    fun getOrderby(): String {
        return orderby
    }

    fun setOrderby(orderby: String) {
        this.orderby = orderby

        addFilter("orderby", orderby)
    }

    fun addFilter(filter: String, value: Any) {
        if (value.javaClass.isArray) {
            if (value is IntArray) {
                var values = ""
                for (item in value) {
                    values += "$item,"
                }

                filters[filter] = "" + values.substring(0, values.length - 1)

            } else {
                val list = Arrays.asList(value)
                for (item in list) {
                    filters[filter] = item.toString()
                }
            }
        } else {
            filters[filter] = value.toString()
        }
    }

    fun getFilters(): Map<String, String> {
        return filters
    }

}

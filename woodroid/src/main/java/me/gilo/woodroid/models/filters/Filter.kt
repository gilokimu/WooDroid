package me.gilo.woodroid.models.filters

import java.util.HashMap

open class Filter {

    internal lateinit var context: String

    internal var filters: MutableMap<String, String> = HashMap()

    fun getContext(): String {
        return context
    }

    fun setContext(context: String) {
        this.context = context

        addFilter("context", context)
    }

    fun addFilter(filter: String, value: Any) {
        filters[filter] = value.toString()
    }

    fun getFilters(): Map<String, String> {
        return filters
    }
}

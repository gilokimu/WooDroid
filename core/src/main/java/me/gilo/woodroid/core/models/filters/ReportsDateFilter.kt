package me.gilo.woodroid.models.filters

class ReportsDateFilter : Filter() {

    internal lateinit var period: String
    internal lateinit var date_min: String
    internal lateinit var date_max: String

    fun getPeriod(): String {
        return period
    }

    fun setPeriod(period: String) {
        this.period = period

        addFilter("period", period)
    }

    fun getDate_min(): String {
        return date_min
    }

    fun setDate_min(date_min: String) {
        this.date_min = date_min

        addFilter("date_min", date_min)
    }

    fun getDate_max(): String {
        return date_max
    }

    fun setDate_max(date_max: String) {
        this.date_max = date_max

        addFilter("date_max", date_max)
    }
}

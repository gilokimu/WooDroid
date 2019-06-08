package me.gilo.woodroid.models

/**
 * Created by gilo on 1/19/16.
 */
class Meta {

    var thousand_separator: String? = null
    var decimal_separator: String? = null
    var currency_position: String? = null
    var weight_unit: String? = null
    var currency: String? = null
    var timezone: String? = null
    var isGenerate_password: Boolean = false
    var price_num_decimals: Int = 0
    var isTax_included: Boolean = false
    var isSsl_enabled: Boolean = false
    var isPermalinks_enabled: Boolean = false
    var dimension_unit: String? = null
    var currency_format: String? = null

    override fun toString(): String {
        return "ClassPojo [thousand_separator = $thousand_separator, decimal_separator = $decimal_separator, currency_position = $currency_position, weight_unit = $weight_unit, currency = $currency, timezone = $timezone, generate_password = $isGenerate_password, price_num_decimals = $price_num_decimals, tax_included = $isTax_included, ssl_enabled = $isSsl_enabled, permalinks_enabled = $isPermalinks_enabled, dimension_unit = $dimension_unit, currency_format = $currency_format]"
    }
}

package me.gilo.woodroid.models;

/**
 * Created by gilo on 1/19/16.
 */
public class Meta {

    private String thousand_separator;
    private String decimal_separator;
    private String currency_position;
    private String weight_unit;
    private String currency;
    private String timezone;
    private boolean generate_password;
    private int price_num_decimals;
    private boolean tax_included;
    private boolean ssl_enabled;
    private boolean permalinks_enabled;
    private String dimension_unit;
    private String currency_format;

    public String getThousand_separator() {
        return thousand_separator;
    }

    public void setThousand_separator(String thousand_separator) {
        this.thousand_separator = thousand_separator;
    }

    public String getDecimal_separator() {
        return decimal_separator;
    }

    public void setDecimal_separator(String decimal_separator) {
        this.decimal_separator = decimal_separator;
    }

    public String getCurrency_position() {
        return currency_position;
    }

    public void setCurrency_position(String currency_position) {
        this.currency_position = currency_position;
    }

    public String getWeight_unit() {
        return weight_unit;
    }

    public void setWeight_unit(String weight_unit) {
        this.weight_unit = weight_unit;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public boolean isGenerate_password() {
        return generate_password;
    }

    public void setGenerate_password(boolean generate_password) {
        this.generate_password = generate_password;
    }

    public int getPrice_num_decimals() {
        return price_num_decimals;
    }

    public void setPrice_num_decimals(int price_num_decimals) {
        this.price_num_decimals = price_num_decimals;
    }

    public boolean isTax_included() {
        return tax_included;
    }

    public void setTax_included(boolean tax_included) {
        this.tax_included = tax_included;
    }

    public boolean isSsl_enabled() {
        return ssl_enabled;
    }

    public void setSsl_enabled(boolean ssl_enabled) {
        this.ssl_enabled = ssl_enabled;
    }

    public boolean isPermalinks_enabled() {
        return permalinks_enabled;
    }

    public void setPermalinks_enabled(boolean permalinks_enabled) {
        this.permalinks_enabled = permalinks_enabled;
    }

    public String getDimension_unit() {
        return dimension_unit;
    }

    public void setDimension_unit(String dimension_unit) {
        this.dimension_unit = dimension_unit;
    }

    public String getCurrency_format() {
        return currency_format;
    }

    public void setCurrency_format(String currency_format) {
        this.currency_format = currency_format;
    }

    @Override
    public String toString() {
        return "ClassPojo [thousand_separator = " + thousand_separator + ", decimal_separator = " + decimal_separator +  ", currency_position = " + currency_position + ", weight_unit = " + weight_unit + ", currency = " + currency + ", timezone = " + timezone + ", generate_password = " + generate_password + ", price_num_decimals = " + price_num_decimals + ", tax_included = " + tax_included + ", ssl_enabled = " + ssl_enabled + ", permalinks_enabled = " + permalinks_enabled + ", dimension_unit = " + dimension_unit + ", currency_format = " + currency_format + "]";
    }
}

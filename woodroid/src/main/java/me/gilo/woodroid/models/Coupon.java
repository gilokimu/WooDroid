package me.gilo.woodroid.models;

import java.io.Serializable;

public class Coupon implements Serializable{

    private int usage_limit;
    private String code;
    private String free_shipping;
    private String description;
    private String minimum_amount;
    private String[] email_restrictions;
    private String exclude_sale_items;
    private String[] excluded_product_ids;
    private String usage_count;
    private String individual_use;
    private int usage_limit_per_user;
    private int limit_usage_to_x_items;
    private String[] meta_data;
    private String id;
    private String date_modified_gmt;
    private String amount;
    private String date_created;
    private String date_created_gmt;
    private String maximum_amount;
    private String discount_type;
    private String[] used_by;
    private String date_modified;
    private String[] product_ids;
    private String[] product_categories;
    private String date_expires;
    private String[] excluded_product_categories;
    private String date_expires_gmt;

    public int getUsage_limit() {
        return usage_limit;
    }

    public void setUsage_limit(int usage_limit) {
        this.usage_limit = usage_limit;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFree_shipping() {
        return free_shipping;
    }

    public void setFree_shipping(String free_shipping) {
        this.free_shipping = free_shipping;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMinimum_amount() {
        return minimum_amount;
    }

    public void setMinimum_amount(String minimum_amount) {
        this.minimum_amount = minimum_amount;
    }

    public String[] getEmail_restrictions() {
        return email_restrictions;
    }

    public void setEmail_restrictions(String[] email_restrictions) {
        this.email_restrictions = email_restrictions;
    }

    public String getExclude_sale_items() {
        return exclude_sale_items;
    }

    public void setExclude_sale_items(String exclude_sale_items) {
        this.exclude_sale_items = exclude_sale_items;
    }

    public String[] getExcluded_product_ids() {
        return excluded_product_ids;
    }

    public void setExcluded_product_ids(String[] excluded_product_ids) {
        this.excluded_product_ids = excluded_product_ids;
    }

    public String getUsage_count() {
        return usage_count;
    }

    public void setUsage_count(String usage_count) {
        this.usage_count = usage_count;
    }

    public String getIndividual_use() {
        return individual_use;
    }

    public void setIndividual_use(String individual_use) {
        this.individual_use = individual_use;
    }

    public int getUsage_limit_per_user() {
        return usage_limit_per_user;
    }

    public void setUsage_limit_per_user(int usage_limit_per_user) {
        this.usage_limit_per_user = usage_limit_per_user;
    }

    public int getLimit_usage_to_x_items() {
        return limit_usage_to_x_items;
    }

    public void setLimit_usage_to_x_items(int limit_usage_to_x_items) {
        this.limit_usage_to_x_items = limit_usage_to_x_items;
    }

    public String[] getMeta_data() {
        return meta_data;
    }

    public void setMeta_data(String[] meta_data) {
        this.meta_data = meta_data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate_modified_gmt() {
        return date_modified_gmt;
    }

    public void setDate_modified_gmt(String date_modified_gmt) {
        this.date_modified_gmt = date_modified_gmt;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public String getDate_created_gmt() {
        return date_created_gmt;
    }

    public void setDate_created_gmt(String date_created_gmt) {
        this.date_created_gmt = date_created_gmt;
    }

    public String getMaximum_amount() {
        return maximum_amount;
    }

    public void setMaximum_amount(String maximum_amount) {
        this.maximum_amount = maximum_amount;
    }

    public String getDiscount_type() {
        return discount_type;
    }

    public void setDiscount_type(String discount_type) {
        this.discount_type = discount_type;
    }

    public String[] getUsed_by() {
        return used_by;
    }

    public void setUsed_by(String[] used_by) {
        this.used_by = used_by;
    }

    public String getDate_modified() {
        return date_modified;
    }

    public void setDate_modified(String date_modified) {
        this.date_modified = date_modified;
    }

    public String[] getProduct_ids() {
        return product_ids;
    }

    public void setProduct_ids(String[] product_ids) {
        this.product_ids = product_ids;
    }

    public String[] getProduct_categories() {
        return product_categories;
    }

    public void setProduct_categories(String[] product_categories) {
        this.product_categories = product_categories;
    }

    public String getDate_expires() {
        return date_expires;
    }

    public void setDate_expires(String date_expires) {
        this.date_expires = date_expires;
    }

    public String[] getExcluded_product_categories() {
        return excluded_product_categories;
    }

    public void setExcluded_product_categories(String[] excluded_product_categories) {
        this.excluded_product_categories = excluded_product_categories;
    }

    public String getDate_expires_gmt() {
        return date_expires_gmt;
    }

    public void setDate_expires_gmt(String date_expires_gmt) {
        this.date_expires_gmt = date_expires_gmt;
    }
}

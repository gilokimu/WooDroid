package me.gilo.woodroid.models;

import java.io.Serializable;

/**
 * Created by Aron on 1/24/2016.
 */
public class Coupon implements Serializable{
    private String[] customer_emails;

    private double maximum_amount;
    private int usage_limit_per_user;
    private String exclude_sale_items;
    private String code;
    private boolean individual_use;
    private String type;
    private int[] product_ids;
    private int amount;
    private int limit_usage_to_x_items;
    private int[] product_category_ids;
    private String description;
    private double minimum_amount;
    private String expiry_date;
    private int[] exclude_product_ids;
    private boolean enable_free_shipping;
    private int[] exclude_product_category_ids;
    private int usage_limit;
    public String[] getCustomer_emails() {
        return customer_emails;
    }

    public void setCustomer_emails(String[] customer_emails) {
        this.customer_emails = customer_emails;
    }

    public double getMaximum_amount() {
        return maximum_amount;
    }

    public void setMaximum_amount(double maximum_amount) {
        this.maximum_amount = maximum_amount;
    }

    public int getUsage_limit_per_user() {
        return usage_limit_per_user;
    }

    public void setUsage_limit_per_user(int usage_limit_per_user) {
        this.usage_limit_per_user = usage_limit_per_user;
    }

    public String getExclude_sale_items() {
        return exclude_sale_items;
    }

    public void setExclude_sale_items(String exclude_sale_items) {
        this.exclude_sale_items = exclude_sale_items;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isIndividual_use() {
        return individual_use;
    }

    public void setIndividual_use(boolean individual_use) {
        this.individual_use = individual_use;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int[] getProduct_ids() {
        return product_ids;
    }

    public void setProduct_ids(int[] product_ids) {
        this.product_ids = product_ids;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getLimit_usage_to_x_items() {
        return limit_usage_to_x_items;
    }

    public void setLimit_usage_to_x_items(int limit_usage_to_x_items) {
        this.limit_usage_to_x_items = limit_usage_to_x_items;
    }

    public int[] getProduct_category_ids() {
        return product_category_ids;
    }

    public void setProduct_category_ids(int[] product_category_ids) {
        this.product_category_ids = product_category_ids;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getMinimum_amount() {
        return minimum_amount;
    }

    public void setMinimum_amount(double minimum_amount) {
        this.minimum_amount = minimum_amount;
    }

    public String getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(String expiry_date) {
        this.expiry_date = expiry_date;
    }

    public int[] getExclude_product_ids() {
        return exclude_product_ids;
    }

    public void setExclude_product_ids(int[] exclude_product_ids) {
        this.exclude_product_ids = exclude_product_ids;
    }

    public boolean isEnable_free_shipping() {
        return enable_free_shipping;
    }

    public void setEnable_free_shipping(boolean enable_free_shipping) {
        this.enable_free_shipping = enable_free_shipping;
    }

    public int[] getExclude_product_category_ids() {
        return exclude_product_category_ids;
    }

    public void setExclude_product_category_ids(int[] exclude_product_category_ids) {
        this.exclude_product_category_ids = exclude_product_category_ids;
    }

    public int getUsage_limit() {
        return usage_limit;
    }

    public void setUsage_limit(int usage_limit) {
        this.usage_limit = usage_limit;
    }
}

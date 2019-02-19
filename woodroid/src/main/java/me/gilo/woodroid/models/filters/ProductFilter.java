package me.gilo.woodroid.models.filters;

import android.util.Log;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ProductFilter{
    String context;
    int page;
    int per_page;
    String search;
    String after;
    String before;
    int[] exclude;
    int[] include;
    int offset;
    String order;
    String orderby;
    int[] parent;
    int[] parent_exclude;
    String slug;
    String status;
    String type;
    String sku;
    boolean featured;
    String category;
    String tag;
    String shipping_class;
    String attribute;
    String attribute_term;
    String tax_class;
    boolean on_sale;
    String min_price;
    String max_price;
    String stock_status;

    Map<String, String> filters = new HashMap<>();

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;

        addFilter("context", context);
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;

        addFilter("page", page);
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;

        addFilter("per_page", per_page);
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;

        addFilter("search", search);
    }

    public String getAfter() {
        return after;
    }

    public void setAfter(String after) {
        this.after = after;

        addFilter("after", after);
    }

    public String getBefore() {
        return before;
    }

    public void setBefore(String before) {
        this.before = before;

        addFilter("before", before);
    }

    public int[] getExclude() {
        return exclude;
    }

    public void setExclude(int[] exclude) {
        this.exclude = exclude;

        addFilter("exclude", exclude);
    }

    public int[] getInclude() {
        return include;
    }

    public void setInclude(int[] include) {
        this.include = include;

        addFilter("include", include);
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;

        addFilter("offset", offset);
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;

        addFilter("order", order);
    }

    public String getOrderby() {
        return orderby;
    }

    public void setOrderby(String orderby) {
        this.orderby = orderby;

        addFilter("orderby", orderby);
    }

    public int[] getParent() {
        return parent;
    }

    public void setParent(int[] parent) {
        this.parent = parent;

        addFilter("parent", parent);

    }

    public int[] getParent_exclude() {
        return parent_exclude;
    }

    public void setParent_exclude(int[] parent_exclude) {
        this.parent_exclude = parent_exclude;

        addFilter("parent_exclude", parent_exclude);

    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;

        addFilter("slug", slug);

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;

        addFilter("status", status);

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;

        addFilter("type", type);
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;

        addFilter("sku", sku);
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;

        addFilter("featured", featured);
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;

        addFilter("category", category);
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;

        addFilter("tag", tag);
    }

    public String getShipping_class() {
        return shipping_class;
    }

    public void setShipping_class(String shipping_class) {
        this.shipping_class = shipping_class;

        addFilter("shipping_class", shipping_class);
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;

        addFilter("attribute", attribute);
    }

    public String getAttribute_term() {
        return attribute_term;
    }

    public void setAttribute_term(String attribute_term) {
        this.attribute_term = attribute_term;

        addFilter("attribute_term", attribute_term);
    }


    public String getTax_class() {
        return tax_class;
    }

    public void setTax_class(String tax_class) {
        this.tax_class = tax_class;

        addFilter("tax_class", tax_class);
    }

    public boolean isOn_sale() {
        return on_sale;
    }

    public void setOn_sale(boolean on_sale) {
        this.on_sale = on_sale;

        addFilter("on_sale", on_sale);
    }

    public String getMin_price() {
        return min_price;
    }

    public void setMin_price(String min_price) {
        this.min_price = min_price;

        addFilter("min_price", min_price);
    }

    public String getMax_price() {
        return max_price;
    }

    public void setMax_price(String max_price) {
        this.max_price = max_price;

        addFilter("max_price", max_price);
    }

    public String getStock_status() {
        return stock_status;
    }

    public void setStock_status(String stock_status) {
        this.stock_status = stock_status;

        addFilter("stock_status", stock_status);
    }

    public void addFilter(String filter, Object value){
        filters.put(filter, value.toString());
    }

    public Map<String, String> getFilters() {
        return filters;
    }
}

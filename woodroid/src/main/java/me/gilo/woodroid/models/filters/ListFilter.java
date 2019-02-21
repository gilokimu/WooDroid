package me.gilo.woodroid.models.filters;

import me.gilo.woodroid.utils.Converter;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ListFilter {

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

    public void setAfter(Date date) {
        setAfter(Converter.getDateString(date));
    }

    public void setBefore(Date date) {
        setBefore(Converter.getDateString(date));
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

    public void setOrder(Sort order) {
       setOrder(order.toString());
    }

    public String getOrderby() {
        return orderby;
    }

    public void setOrderby(String orderby) {
        this.orderby = orderby;

        addFilter("orderby", orderby);
    }

    public void addFilter(String filter, Object value){
        filters.put(filter, value.toString());
    }

    public Map<String, String> getFilters() {
        return filters;
    }
    
}

package me.gilo.woodroid.models.filters;

import java.util.HashMap;
import java.util.Map;

public class ProductAttributeFilter {

    String context;

    Map<String, String> filters = new HashMap<>();

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;

        addFilter("context", context);
    }

    public void addFilter(String filter, Object value) {
        filters.put(filter, value.toString());
    }

    public Map<String, String> getFilters() {
        return filters;
    }
}

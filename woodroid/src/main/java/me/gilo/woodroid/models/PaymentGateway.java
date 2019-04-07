package me.gilo.woodroid.models;

import java.util.Map;

public class PaymentGateway {

    String id;
    String title;
    String description;
    int order;
    boolean enabled;
    String method_title;
    String method_description;
    String[] method_supports;
    Map<String, PaymentGatewaySetting> settings;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getMethod_title() {
        return method_title;
    }

    public void setMethod_title(String method_title) {
        this.method_title = method_title;
    }

    public String getMethod_description() {
        return method_description;
    }

    public void setMethod_description(String method_description) {
        this.method_description = method_description;
    }

    public String[] getMethod_supports() {
        return method_supports;
    }

    public void setMethod_supports(String[] method_supports) {
        this.method_supports = method_supports;
    }

    public Map<String, PaymentGatewaySetting> getSettings() {
        return settings;
    }

    public void setSettings(Map<String, PaymentGatewaySetting> settings) {
        this.settings = settings;
    }
}

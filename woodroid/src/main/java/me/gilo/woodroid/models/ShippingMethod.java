package me.gilo.woodroid.models;

import com.google.gson.annotations.SerializedName;


public class ShippingMethod {
    private String id;
    private String title;
    private String descriptioon;

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

    public String getDescriptioon() {
        return descriptioon;
    }

    public void setDescriptioon(String descriptioon) {
        this.descriptioon = descriptioon;
    }
}

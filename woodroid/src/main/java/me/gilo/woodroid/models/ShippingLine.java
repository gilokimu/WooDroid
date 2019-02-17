package me.gilo.woodroid.models;

import com.google.gson.annotations.SerializedName;


public class ShippingLine {
    @SerializedName("method_id")
    private String id;
    @SerializedName("method_title")
    private String methodTitle;
    private int total;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMethodTitle() {
        return methodTitle;
    }

    public void setMethodTitle(String methodTitle) {
        this.methodTitle = methodTitle;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}

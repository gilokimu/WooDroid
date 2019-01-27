package me.gilo.woodroid.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Aron on 12/7/2015.
 */
public class PaymentDetails {
    @SerializedName("method_id")
    public String methodId;
    @SerializedName("method_title")
    public String methodTitle;
    public Boolean paid;

    public String getMethodId() {
        return methodId;
    }

    public void setMethodId(String methodId) {
        this.methodId = methodId;
    }

    public String getMethodTitle() {
        return methodTitle;
    }

    public void setMethodTitle(String methodTitle) {
        this.methodTitle = methodTitle;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }
}

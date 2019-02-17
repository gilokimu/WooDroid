package me.gilo.woodroid.models;

import android.os.Parcel;

import java.io.Serializable;


public class Dimension implements Serializable {

    private String length;
    private String width;
    private String height;
    private String unit;

    protected Dimension(Parcel in) {
        length = in.readString();
        width = in.readString();
        height = in.readString();
        unit = in.readString();
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}

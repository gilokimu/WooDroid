package me.gilo.woodroid.models;

import android.os.Parcel;

import java.io.Serializable;

/**
 * Created by Aron on 11/26/2015.
 */
public class DefaultAttribute implements Serializable {
    int id;
    String name;
    String option;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }
}

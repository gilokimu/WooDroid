package me.gilo.woodroid.models;

import java.io.Serializable;

public class Metadata implements Serializable {
    int id;
    String key;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }


}

package me.gilo.woodroid.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;


public class CustomerPost implements Serializable{
    @SerializedName("data")
    ArrayList<Data> datas;

    public ArrayList<Data> getDatas() {
        return datas;
    }

    public void setDatas(ArrayList<Data> datas) {
        this.datas = datas;
    }
}

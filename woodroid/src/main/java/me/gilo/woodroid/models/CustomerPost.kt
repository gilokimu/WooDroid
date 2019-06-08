package me.gilo.woodroid.models

import com.google.gson.annotations.SerializedName

import java.io.Serializable
import java.util.ArrayList


class CustomerPost : Serializable {
    @SerializedName("data")
    lateinit var datas: ArrayList<Data>
}

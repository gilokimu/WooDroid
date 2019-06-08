package me.gilo.woodroid.data.callbacks

import com.google.gson.annotations.SerializedName
import me.gilo.woodroid.models.Store

class StoreCallback {

    @SerializedName("store")
    lateinit var store: Store
}

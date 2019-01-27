package me.gilo.woodroid.data.callbacks;

import com.google.gson.annotations.SerializedName;
import me.gilo.woodroid.models.Store;

/**
 * Created by Aron on 2/20/2016.
 */
public class StoreCallback {

    @SerializedName("store")
    Store store;

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}

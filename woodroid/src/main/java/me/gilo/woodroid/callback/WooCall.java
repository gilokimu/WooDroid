package me.gilo.woodroid.callback;

import android.arch.lifecycle.LiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public interface WooCall<T> extends Call<T> {

}

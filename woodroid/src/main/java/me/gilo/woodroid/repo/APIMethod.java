package me.gilo.woodroid.repo;

import me.gilo.woodroid.models.Coupon;
import retrofit2.Call;

import java.util.List;

public interface APIMethod<T> {
    Call<T> create(T data);
    Call<T> get(int id);
    Call<List<T>> all();
    Call<T> update(int id, T data);
    Call<T> delete(int id);
    Call<T> delete(int id, boolean force);

}

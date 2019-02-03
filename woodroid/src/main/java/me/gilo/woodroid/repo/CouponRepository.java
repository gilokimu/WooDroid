package me.gilo.woodroid.repo;

import me.gilo.woodroid.data.CouponAPI;
import me.gilo.woodroid.models.Coupon;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CouponRepository extends WooRepository{

    private final CouponAPI apiService;

    public CouponRepository(String baseUrl, String consumerKey, String consumerSecret) {
       super(baseUrl, consumerKey, consumerSecret);
       apiService = retrofit.create(CouponAPI.class);
    }

    public Call<Coupon> create(Coupon coupon) {
        return apiService.create(coupon);
    }


    public Call<Coupon> coupon(int id) {
        return apiService.view(id);
    }

    public Call<List<Coupon>> coupons() {
        return apiService.list();
    }

    public Call<Coupon> update(int id, Coupon coupon) {
        return apiService.update(id, coupon);
    }

    public Call<Coupon> delete(int id) {
        return apiService.delete(id);
    }

    public Call<Coupon> delete(int id, boolean force) {
        return apiService.delete(id, force);
    }


}

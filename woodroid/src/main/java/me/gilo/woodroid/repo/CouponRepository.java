package me.gilo.woodroid.repo;

import me.gilo.woodroid.data.api.CouponAPI;
import me.gilo.woodroid.models.Coupon;
import me.gilo.woodroid.models.filters.CouponFilter;
import retrofit2.Call;

import java.util.List;

public class CouponRepository extends WooRepository{

    private final CouponAPI apiService;

    public CouponRepository(String baseUrl, String consumerKey, String consumerSecret) {
       super( baseUrl, consumerKey, consumerSecret);
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

    public Call<List<Coupon>> coupons(CouponFilter couponFilter) {
        return apiService.filter(couponFilter.getFilters());
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

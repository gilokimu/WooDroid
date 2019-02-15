package me.gilo.woodroid.services;

import me.gilo.woodroid.models.Coupon;
import me.gilo.woodroid.repo.CouponRepository;
import retrofit2.Call;

import java.util.List;

public class CouponService {

    final CouponRepository couponRepository;

    public CouponService(String baseUrl, String consumerKey, String consumerSecret) {
        couponRepository = new CouponRepository(baseUrl, consumerKey, consumerSecret);
    }

    public Call<Coupon> create(Coupon coupon) {
        return couponRepository.create(coupon);
    }


    public Call<Coupon> coupon(int id) {
        return couponRepository.coupon(id);
    }

    public Call<List<Coupon>> coupons() {
        return couponRepository.coupons();
    }

    public Call<Coupon> update(int id, Coupon coupon) {
        return couponRepository.update(id, coupon);
    }

    public Call<Coupon> delete(int id) {
        return couponRepository.delete(id);
    }

    public Call<Coupon> delete(int id, boolean force) {
        return couponRepository.delete(id, force);
    }

}

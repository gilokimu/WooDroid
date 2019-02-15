package me.gilo.woodroid;

import me.gilo.woodroid.models.Product;
import me.gilo.woodroid.repo.ProductRepository;
import me.gilo.woodroid.services.CouponService;
import retrofit2.Call;

import java.util.List;

public class Woocommerce {

    private String baseUrl;
    private String siteUrl;
    private String apiVerion;
    private String consumerKey;
    private String consumerSecret;

    final ProductRepository productRepository;
    final CouponService couponService;

    public Woocommerce(String siteUrl, String apiVerion, String consumerKey, String consumerSecret) {
        this.siteUrl = siteUrl;
        this.apiVerion = apiVerion;
        this.consumerKey = consumerKey;
        this.consumerSecret = consumerSecret;

        this.baseUrl = siteUrl + "/wp-json/wc/v" + apiVerion + "/";

        productRepository = new ProductRepository(baseUrl, consumerKey, consumerSecret);
        couponService = new CouponService(baseUrl, consumerKey, consumerSecret);
    }


    public static class Builder {
        private String siteUrl;
        private String apiVerion;
        private String consumerKey;
        private String consumerSecret;


        public Builder() {
        }

        public Builder setSiteUrl(String siteUrl) {
            this.siteUrl = siteUrl;
            return this;
        }

        public Builder setApiVersion(String apiVerion) {
            this.apiVerion = apiVerion;
            return this;
        }

        public Builder setConsumerKey(String consumerKey) {
            this.consumerKey = consumerKey;
            return this;
        }

        public Builder setConsumerSecret(String consumerSecret) {
            this.consumerSecret = consumerSecret;
            return this;
        }


        public Woocommerce build() {
            return new Woocommerce(siteUrl, apiVerion, consumerKey, consumerSecret);
        }
    }


    public Call<List<Product>> getProducts() {
        return productRepository.products();
    }

    public CouponService Coupon() {
        return couponService;
    }
}

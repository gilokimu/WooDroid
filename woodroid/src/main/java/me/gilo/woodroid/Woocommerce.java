package me.gilo.woodroid;

import me.gilo.woodroid.models.Product;
import me.gilo.woodroid.repo.ProductRepository;
import me.gilo.woodroid.services.CouponService;
import retrofit2.Call;

import java.util.List;

public class Woocommerce {

    public static final ApiVersion API_V1 = ApiVersion.API_VERSION1;
    public static final ApiVersion API_V2 = ApiVersion.API_VERSION2;

    private String baseUrl;
    private String siteUrl;
    private ApiVersion apiVerion;
    private String consumerKey;
    private String consumerSecret;

    final ProductRepository productRepository;
    final CouponService couponService;

    enum ApiVersion {
        API_VERSION1{
            @Override
            public String toString() {
                return "1";
            }
        },
        API_VERSION2{
            @Override
            public String toString() {
                return "2";
            }
        };
    }

    public Woocommerce(String siteUrl, ApiVersion apiVerion, String consumerKey, String consumerSecret) {
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
        private ApiVersion apiVerion;
        private String consumerKey;
        private String consumerSecret;


        public Builder() {
        }

        public Builder setSiteUrl(String siteUrl) {
            this.siteUrl = siteUrl;
            return this;
        }

        public Builder setApiVersion(ApiVersion apiVerion) {
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

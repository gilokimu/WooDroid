package me.gilo.woodroid;

import me.gilo.woodroid.services.CouponService;
import me.gilo.woodroid.services.CustomerService;
import me.gilo.woodroid.services.OrderService;
import me.gilo.woodroid.services.ProductService;

public class Woocommerce {

    public static final ApiVersion API_V1 = ApiVersion.API_VERSION1;
    public static final ApiVersion API_V2 = ApiVersion.API_VERSION2;

    final CouponService couponService;
    final CustomerService customerService;
    final OrderService orderService;
    final ProductService productService;

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
        },
        API_VERSION3{
            @Override
            public String toString() {
                return "3";
            }
        },
    }

    public Woocommerce(String siteUrl, ApiVersion apiVerion, String consumerKey, String consumerSecret) {
        String baseUrl = siteUrl + "/wp-json/wc/v" + apiVerion + "/";
        couponService = new CouponService(baseUrl, consumerKey, consumerSecret);
        customerService = new CustomerService(baseUrl, consumerKey, consumerSecret);
        orderService = new OrderService(baseUrl, consumerKey, consumerSecret);
        productService = new ProductService(baseUrl, consumerKey, consumerSecret);
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

    public CouponService Coupon() {
        return couponService;
    }

    public CustomerService Customer() {
        return customerService;
    }

    public OrderService Order() {
        return orderService;
    }

    public ProductService Product() {
        return productService;
    }
}

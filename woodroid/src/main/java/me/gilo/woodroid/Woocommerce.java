package me.gilo.woodroid;

import me.gilo.woodroid.models.Product;
import me.gilo.woodroid.repo.ProductRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;

public class Woocommerce {

    private String baseUrl;
    private String siteUrl;
    private String apiVerion;
    private String consumerKey;
    private String consumerSecret;

    final ProductRepository productRepository;

    public static void main(String args[]){
        System.out.println("Hello");

        Woocommerce woocommerce = new Woocommerce.Builder()
                .setSiteUrl("http://iappsdevelopers.com/codecan/woodroid")
                .setApiVersion("2")
                .setConsumerKey("ck_62b755890341ad3d2bd334433d30b5070eea349f")
                .setConsumerSecret("cs_8f678fedc94cbf520e0240d6eacab4dab2954aaa")
                .build();


        woocommerce.getProducts().enqueue(new Callback<ArrayList<Product>>() {
            @Override
            public void onResponse(Call<ArrayList<Product>> call, Response<ArrayList<Product>> response) {
                ArrayList<Product> products = response.body();
                for (Product product : products){
                    System.out.println(product.getTitle());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Product>> call, Throwable t) {

            }
        });
    }

    public Woocommerce(String siteUrl, String apiVerion, String consumerKey, String consumerSecret) {
        this.siteUrl = siteUrl;
        this.apiVerion = apiVerion;
        this.consumerKey = consumerKey;
        this.consumerSecret = consumerSecret;

        this.baseUrl = siteUrl + "/wp-json/wc/v" + apiVerion + "/";

        productRepository = new ProductRepository(baseUrl, consumerKey, consumerSecret);
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


    public Call<ArrayList<Product>> getProducts() {
        return productRepository.products();
    }


}

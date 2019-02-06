package me.gilo.woodroid.repo;

import me.gilo.woodroid.data.RestAdapter;
import me.gilo.woodroid.data.api.CouponAPI;
import me.gilo.woodroid.models.Coupon;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WooRepository {

    private String baseUrl;
    private String consumerKey;
    private String consumerSecret;

    public RestAdapter restAdapter;
    public Retrofit retrofit;

    public WooRepository(String method, String baseUrl, String consumerKey, String consumerSecret) {
        this.baseUrl = baseUrl;
        this.consumerKey = consumerKey;
        this.consumerSecret = consumerSecret;

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        restAdapter = new RestAdapter(baseUrl, consumerKey, consumerSecret);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(restAdapter.getInterceptor(method, null))
                .addInterceptor(loggingInterceptor)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(15, TimeUnit.SECONDS)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }



}

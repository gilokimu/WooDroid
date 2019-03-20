package me.gilo.woodroid.repo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import me.gilo.woodroid.data.auth.AuthIntercepter;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

public class WooRepository {

    //TODO ('Apply DI or single instance on this')
    public Retrofit retrofit;

    public WooRepository(String baseUrl, String consumerKey, String consumerSecret) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create();


        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new AuthIntercepter(consumerKey, consumerSecret))
                .addInterceptor(loggingInterceptor)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(15, TimeUnit.SECONDS)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
    }



}

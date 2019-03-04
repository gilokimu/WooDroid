package me.gilo.woodroid.repo;

import android.content.Context;
import me.gilo.woodroid.data.api.CartAPI;
import me.gilo.woodroid.data.cookie.AddCookiesInterceptor;
import me.gilo.woodroid.data.cookie.ReceivedCookiesInterceptor;
import me.gilo.woodroid.models.LineItem;
import me.gilo.woodroid.models.filters.CartFilter;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class CartRepository{

    CartAPI apiService;
    Retrofit retrofit;

    String baseUrl;

    public CartRepository(String baseUrl, String consumerKey, String consumerSecret) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


        OkHttpClient client = new OkHttpClient.Builder()
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

        this.baseUrl = baseUrl;

       apiService = retrofit.create(CartAPI.class);
    }

    public void turnOnCookies(Context context){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new AddCookiesInterceptor(context))
                .addInterceptor(new ReceivedCookiesInterceptor(context))
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

        apiService = retrofit.create(CartAPI.class);
    }

    public Call<String> clear() {
        return apiService.clear();
    }


    public Call<Integer> count(int id) {
        return apiService.count();
    }

    public Call<Map<String, LineItem>> cart() {
        return apiService.list();
    }

    public Call<Map<String, LineItem>> addToCart(LineItem lineItem) {
        return apiService.addToCart(lineItem);
    }

    public Call<String> delete(String cardId) {
        CartFilter cartFilter = new CartFilter(cardId);
        return apiService.delete(cartFilter);
    }

    public Call<String> restore(String cardId) {
        CartFilter cartFilter = new CartFilter(cardId);
        return apiService.restore(cartFilter);
    }

    public Call<String> update(String cardId, int quantity) {
        CartFilter cartFilter = new CartFilter(cardId);
        cartFilter.setQuantity(quantity);

        return apiService.update(cartFilter);
    }


}

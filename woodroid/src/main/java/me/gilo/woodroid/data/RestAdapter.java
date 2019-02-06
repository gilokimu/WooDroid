package me.gilo.woodroid.data;

import android.util.Base64;

import me.gilo.woodroid.data.api.API;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestAdapter {

    static String oauth_nonce = "";
    static String oauth_timestamp = "";
    static String oauth_signature_method = "HMAC-SHA1";

    static ArrayList<NameValuePair> params;

    private String baseUrl;
    private String consumerKey;
    private String consumerSecret;

    public RestAdapter(String baseUrl, String consumerKey, String consumerSecret) {
        this.baseUrl = baseUrl;
        this.consumerKey = consumerKey;
        this.consumerSecret = consumerSecret;
    }

    public API createAPI(final String endpoint) {
        return createAPI(endpoint, null);
    }

    public API createAPI(final String endpoint, Map<String, String> query) {

        if (query != null) {
            setParams(endpoint, query);
        }else{
            setParams(endpoint);
        }

        // Define the interceptor, add authentication headers
        Interceptor interceptor = chain -> {

            HttpUrl.Builder builder = chain.request().url().newBuilder();
            for (NameValuePair entry : params) {
                builder.addQueryParameter(entry.getName(), entry.getValue());
            }

            Request newRequest = chain.request()
                    .newBuilder()
                    .url(builder.build())
                    .header("Accept", "application/json")
                    .build();

            return chain.proceed(newRequest);
        };

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(loggingInterceptor)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(15, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                //.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit.create(API.class);
    }

    public API createAPI(Class<API> service, final String endpoint, Map<String, String> query) {

        if (query != null) {
            setParams(endpoint, query);
        }else{
            setParams(endpoint);
        }

        // Define the interceptor, add authentication headers
        Interceptor interceptor = chain -> {

            HttpUrl.Builder builder = chain.request().url().newBuilder();
            for (NameValuePair entry : params) {
                builder.addQueryParameter(entry.getName(), entry.getValue());
            }

            Request newRequest = chain.request()
                    .newBuilder()
                    .url(builder.build())
                    .header("Accept", "application/json")
                    .build();

            return chain.proceed(newRequest);
        };

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(loggingInterceptor)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(15, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                //.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit.create(API.class);
    }

    public Interceptor getInterceptor(final String endpoint, Map<String, String> query) {

        if (query != null) {
            setParams(endpoint, query);
        }else{
            setParams(endpoint);
        }

        // Define the interceptor, add authentication headers
        Interceptor interceptor = chain -> {

            chain.request().method();

            HttpUrl.Builder builder = chain.request().url().newBuilder();
            for (NameValuePair entry : params) {
                builder.addQueryParameter(entry.getName(), entry.getValue());
            }

            Request newRequest = chain.request()
                    .newBuilder()
                    .url(builder.build())
                    .header("Accept", "application/json")
                    .build();

            return chain.proceed(newRequest);
        };


       return interceptor;
    }

    public ArrayList<NameValuePair> setParams(String endpoint) {
        final String uri = baseUrl + endpoint;

        URI uri1 = URI.create(baseUrl + endpoint);
        String urlString = "";
        try {
            URL url = uri1.toURL();
            urlString = url.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        oauth_nonce = getOauth_nonce();
        oauth_timestamp = getOauth_timestamp();

        params = new ArrayList<>();
        params.add(new BasicNameValuePair("oauth_consumer_key", consumerKey));
        params.add(new BasicNameValuePair("oauth_nonce", oauth_nonce));
        params.add(new BasicNameValuePair("oauth_timestamp", oauth_timestamp));
        params.add(new BasicNameValuePair("oauth_signature_method", oauth_signature_method));

        Collections.sort(params, new SortParams());

        String encodedParams = URLEncodedUtils.format(params, "utf-8");

        String string_to_sign = "";
        try {
            string_to_sign = (new StringBuilder("GET&")).append(URLEncoder.encode(uri, "utf-8")).append("&").append(URLEncoder.encode(encodedParams, "utf-8")).toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        try {
            Mac mac = Mac.getInstance("HMAC-SHA1");
            String secret = consumerSecret + "&";

            mac.init(new SecretKeySpec(secret.getBytes("utf-8"), "HMAC-SHA1"));
            String signature = Base64.encodeToString(mac.doFinal(string_to_sign.getBytes("utf-8")), 0).trim();
            params.add(new BasicNameValuePair("oauth_signature", signature));
        } catch (NoSuchAlgorithmException | InvalidKeyException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return params;
    }

    public ArrayList<NameValuePair> setParams(String endpoint, Map<String, String> query) {
        final String uri = baseUrl + endpoint;

        URI uri1 = URI.create(baseUrl + endpoint);
        String urlString = "";
        try {
            URL url = uri1.toURL();
            urlString = url.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        oauth_nonce = getOauth_nonce();
        oauth_timestamp = getOauth_timestamp();

        params = new ArrayList<>();

        Iterator it = query.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            params.add(new BasicNameValuePair((String) pair.getKey(), (String) pair.getValue()));

            it.remove();
        }

        params.add(new BasicNameValuePair("oauth_consumer_key", consumerKey));
        params.add(new BasicNameValuePair("oauth_nonce", oauth_nonce));
        params.add(new BasicNameValuePair("oauth_timestamp", oauth_timestamp));
        params.add(new BasicNameValuePair("oauth_signature_method", oauth_signature_method));

        Collections.sort(params, new SortParams());

        String encodedParams = URLEncodedUtils.format(params, "utf-8");

        String string_to_sign = "";
        try {
            string_to_sign = (new StringBuilder("GET&")).append(URLEncoder.encode(uri, "utf-8")).append("&").append(URLEncoder.encode(encodedParams, "utf-8")).toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        try {
            Mac mac = Mac.getInstance("HMAC-SHA1");
            String secret = consumerSecret;
            //if (API.WP_API_VERSION.equals("3")) {
                secret = consumerSecret + "&";
            //}
            mac.init(new SecretKeySpec(secret.getBytes("utf-8"), "HMAC-SHA1"));
            String signature = Base64.encodeToString(mac.doFinal(string_to_sign.getBytes("utf-8")), 0).trim();
            params.add(new BasicNameValuePair("oauth_signature", signature));
        } catch (NoSuchAlgorithmException | InvalidKeyException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return params;
    }

    public static String getOauth_nonce() {
        return (new StringBuilder(String.valueOf(Math.random() * 100000000D))).toString();
    }

    public static String getOauth_timestamp() {
        long stamp = (long) (System.currentTimeMillis() / 1000D);
        return (new StringBuilder(String.valueOf(stamp))).toString();
    }

    static class SortParams implements Comparator<NameValuePair> {

        @Override
        public int compare(NameValuePair nameValuePair1, NameValuePair nameValuePair2) {
            return nameValuePair1.getName().compareTo(nameValuePair2.getName());
        }
    }
}

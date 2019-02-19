package me.gilo.woodroid.data.auth;

import android.util.Base64;
import android.util.Log;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class AuthIntercepter implements Interceptor {


    static String oauth_nonce = "";
    static String oauth_timestamp = "";
    static String oauth_signature_method = "HMAC-SHA1";
    private String oauth_signature = "";

    private String consumerKey;
    private String consumerSecret;


    public AuthIntercepter(String consumerKey, String consumerSecret) {
        this.consumerKey = consumerKey;
        this.consumerSecret = consumerSecret;
    }


    @Override
    public Response intercept(Chain chain) throws IOException {
        ArrayList<NameValuePair> params = getOauthParams(chain);

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
    }

    public ArrayList<NameValuePair> getOauthParams(Chain chain) {
        ArrayList<NameValuePair> params = new ArrayList<>();

        String request_url = chain.request().url().toString();

        Iterator iterator = getQueryParams(request_url).entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry)iterator.next();

            String key = (String) pair.getKey();
            List<String> values = (List<String>) pair.getValue();
            String value = "";

            //why there would be multiple values for single key is not so clear to me, will keep this here though
            if (values.size() == 1){
                value = values.get(0);
            }

            params.add(new BasicNameValuePair(key, value));

            iterator.remove();
        }

        if (request_url.contains("?")){
            int request_url_end = request_url.indexOf("?");
            request_url = request_url.substring(0, request_url_end);
        }

        oauth_nonce = getOauth_nonce();
        oauth_timestamp = getOauth_timestamp();

        params.add(new BasicNameValuePair("oauth_consumer_key", consumerKey));
        params.add(new BasicNameValuePair("oauth_nonce", oauth_nonce));
        params.add(new BasicNameValuePair("oauth_timestamp", oauth_timestamp));
        params.add(new BasicNameValuePair("oauth_signature_method", oauth_signature_method));

        Collections.sort(params, new AlphabeticSorter());
        String encodedParams = URLEncodedUtils.format(params, "utf-8");
        oauth_signature = getOauth_signature(chain.request().method(), request_url, consumerSecret, encodedParams );

        params.add(new BasicNameValuePair("oauth_signature", oauth_signature));

        return params;
    }

    public String getOauth_nonce() {
        return (new StringBuilder(String.valueOf(Math.random() * 100000000D))).toString();
    }

    public String getStringToSign(String method, String url, String parameters) {
        String string_to_sign = "";
        try {
            string_to_sign = (new StringBuilder(method + "&"))
                    .append(URLEncoder.encode(url, "utf-8")).append("&")
                    .append(URLEncoder.encode(parameters, "utf-8"))
                    .toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return string_to_sign;
    }


    public String getOauth_signature(String method, String url, String consumerSecret, String parameters) {
        String signature = "";
        String string_to_sign = getStringToSign(method, url, parameters);

        try {
            Mac mac = Mac.getInstance(oauth_signature_method);
            String secret = consumerSecret + "&";
            mac.init(new SecretKeySpec(secret.getBytes("utf-8"), oauth_signature_method));
            signature = Base64.encodeToString(mac.doFinal(string_to_sign.getBytes("utf-8")), 0).trim();
        } catch (NoSuchAlgorithmException | InvalidKeyException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return signature;
    }


    public String getOauth_timestamp() {
        long stamp = (long) (System.currentTimeMillis() / 1000D);
        return (new StringBuilder(String.valueOf(stamp))).toString();
    }

    public static Map<String, List<String>> getQueryParams(String url) {
        try {
            Map<String, List<String>> params = new HashMap<String, List<String>>();
            String[] urlParts = url.split("\\?");
            if (urlParts.length > 1) {
                String query = urlParts[1];
                for (String param : query.split("&")) {
                    String[] pair = param.split("=");
                    String key = URLDecoder.decode(pair[0], "UTF-8");
                    String value = "";
                    if (pair.length > 1) {
                        value = URLDecoder.decode(pair[1], "UTF-8");
                    }

                    List<String> values = params.get(key);
                    if (values == null) {
                        values = new ArrayList<String>();
                        params.put(key, values);
                    }
                    values.add(value);
                }
            }

            return params;
        } catch (UnsupportedEncodingException ex) {
            throw new AssertionError(ex);
        }
    }
}

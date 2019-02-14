package me.gilo.woodroid.data;

import org.apache.http.NameValuePair;

import java.util.ArrayList;

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




}

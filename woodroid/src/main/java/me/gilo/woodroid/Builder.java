package me.gilo.woodroid;

import me.gilo.woodroid.data.ApiVersion;

public class Builder {
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
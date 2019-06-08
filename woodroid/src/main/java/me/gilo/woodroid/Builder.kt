package me.gilo.woodroid

import me.gilo.woodroid.data.ApiVersion


class Builder {
    private lateinit var siteUrl: String
    private lateinit var apiVerion: ApiVersion
    private lateinit var consumerKey: String
    private lateinit var consumerSecret: String

    fun setSiteUrl(siteUrl: String): Builder {
        this.siteUrl = siteUrl
        return this
    }

    fun setApiVersion(apiVerion: ApiVersion): Builder {
        this.apiVerion = apiVerion
        return this
    }

    fun setConsumerKey(consumerKey: String): Builder {
        this.consumerKey = consumerKey
        return this
    }

    fun setConsumerSecret(consumerSecret: String): Builder {
        this.consumerSecret = consumerSecret
        return this
    }


    fun build(): Woocommerce {
        return Woocommerce(siteUrl, apiVerion, consumerKey, consumerSecret)
    }
}
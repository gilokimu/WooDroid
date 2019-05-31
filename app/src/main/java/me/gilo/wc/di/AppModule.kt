package me.gilo.wc.di

import dagger.Module
import dagger.Provides
import me.gilo.wc.Config
import me.gilo.wc.WcApp
import me.gilo.woodroid.Woocommerce

import javax.inject.Singleton

@Module
class AppModule {

    internal var app: WcApp? = null

    internal fun AppModule(application: WcApp) {
        app = application
    }

    @Provides
    @Singleton
    internal fun providesApplication(): WcApp {
        return app!!
    }

    @Provides
    @Singleton
    internal fun providesWoocommerce(): Woocommerce {

        return Woocommerce.Builder()
            .setSiteUrl(Config.siteUrl)
            .setApiVersion(Woocommerce.API_V3)
            .setConsumerKey(Config.consumerKey)
            .setConsumerSecret(Config.consumerSecret)
            .build()
    }

}

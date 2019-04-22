package me.gilo.wc.di;

import dagger.Module;
import dagger.Provides;
import me.gilo.wc.Config;
import me.gilo.wc.WcApp;
import me.gilo.woodroid.Woocommerce;

import javax.inject.Singleton;

@Module
public class AppModule {

    WcApp app;

    void AppModule(WcApp application) {
        app = application;
    }

    @Provides
    @Singleton
    WcApp providesApplication() {
        return app;
    }

    @Provides
    @Singleton
    Woocommerce providesWoocommerce() {
        Woocommerce woocommerce = Woocommerce.Builder()
                .setSiteUrl(Config.siteUrl)
                .setApiVersion(Woocommerce.API_V3)
                .setConsumerKey(Config.consumerKey)
                .setConsumerSecret(Config.consumerSecret)
                .build();

        return woocommerce;
    }

}

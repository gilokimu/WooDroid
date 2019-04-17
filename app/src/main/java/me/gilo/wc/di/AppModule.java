package me.gilo.wc.di;

import dagger.Module;
import dagger.Provides;
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
                .setSiteUrl("http://157.230.131.179")
                .setApiVersion(Woocommerce.API_V3)
                .setConsumerKey("ck_26c61abd7eeff238d87dc56585bf26cb2d1a1ec3")
                .setConsumerSecret("cs_062e8e3a7ae0ce08fdebc0c39f8f834d5e87598e")
                .build();

        return woocommerce;
    }

}

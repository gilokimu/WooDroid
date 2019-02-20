package me.gilo.wc.di;

import dagger.Module;
import dagger.Provides;
import me.gilo.wc.WcApp;

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

}

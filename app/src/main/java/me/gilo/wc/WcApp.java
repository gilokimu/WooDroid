package me.gilo.wc;

import android.app.Application;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;
import me.gilo.wc.di.DaggerAppComponent;

public class WcApp extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        ViewPump.init(ViewPump.builder()
                .addInterceptor(new CalligraphyInterceptor(
                        new CalligraphyConfig.Builder()
                                .setDefaultFontPath("fonts/GT-America-Regular.otf")
                                .setFontAttrId(R.attr.fontPath)
                                .build()))
                .build());


    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.create();
    }
}

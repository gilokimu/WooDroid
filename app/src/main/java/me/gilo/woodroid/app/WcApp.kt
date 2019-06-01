package me.gilo.woodroid.app

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump
import me.gilo.woodroid.app.R
import me.gilo.woodroid.app.di.DaggerAppComponent

class WcApp : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()

        ViewPump.init(
            ViewPump.builder()
                .addInterceptor(
                    CalligraphyInterceptor(
                        CalligraphyConfig.Builder()
                            .setDefaultFontPath("fonts/GT-America-Regular.otf")
                            .setFontAttrId(R.attr.fontPath)
                            .build()
                    )
                )
                .build()
        )


    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
       return DaggerAppComponent.create()
    }
}

package me.gilo.wc.di;


import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;
import me.gilo.wc.WcApp;

import javax.inject.Singleton;


@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ViewModelModule.class,
        ActivitiesModule.class,
})
interface AppComponent extends AndroidInjector<DaggerApplication> {

    void inject(WcApp app);

}

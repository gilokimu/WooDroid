package me.gilo.woodroid.app.di


import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import me.gilo.woodroid.app.WcApp

import javax.inject.Singleton


@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, ViewModelModule::class, FirebaseModule::class, ActivitiesModule::class, AppModule::class])
internal interface AppComponent : AndroidInjector<DaggerApplication> {

    fun inject(app: WcApp)

}

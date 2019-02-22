package me.gilo.wc.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import me.gilo.wc.MainActivity;
import me.gilo.wc.ui.product.ProductActivity;
import me.gilo.wc.ui.product.ShopActivity;

@Module
abstract class ActivitiesModule {

    @ContributesAndroidInjector
    abstract MainActivity contributesMainActivity();

    @ContributesAndroidInjector
    abstract ShopActivity contributesShopActivity();

    @ContributesAndroidInjector
    abstract ProductActivity contributesProductActivity();

}

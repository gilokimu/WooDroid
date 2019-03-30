package me.gilo.wc.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import me.gilo.raison.ui.user.onboarding.SignInActivity;
import me.gilo.raison.ui.user.onboarding.SignUpActivity;
import me.gilo.wc.MainActivity;
import me.gilo.wc.ui.home.HomeActivity;
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

    @ContributesAndroidInjector
    abstract HomeActivity contributesHomeActivity();

    @ContributesAndroidInjector
    abstract SignInActivity contributesSignInActivity();

    @ContributesAndroidInjector
    abstract SignUpActivity contributesSignUpActivity();

}

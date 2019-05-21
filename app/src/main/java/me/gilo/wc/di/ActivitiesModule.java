package me.gilo.wc.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import me.gilo.raison.ui.user.onboarding.SignInActivity;
import me.gilo.raison.ui.user.onboarding.SignUpActivity;
import me.gilo.wc.MainActivity;
import me.gilo.wc.ui.WooDroidActivity;
import me.gilo.wc.ui.customer.BasicCustomerDetailsActivity;
import me.gilo.wc.ui.customer.BillingAddressActivity;
import me.gilo.wc.ui.customer.ProfileActivity;
import me.gilo.wc.ui.customer.ShippingAddressActivity;
import me.gilo.wc.ui.home.HomeActivity;
import me.gilo.wc.ui.onboarding.AnonymousSignInActivity;
import me.gilo.wc.ui.order.MyOrdersActivity;
import me.gilo.wc.ui.order.OrderActivity;
import me.gilo.wc.ui.product.CartActivity;
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

    @ContributesAndroidInjector
    abstract BasicCustomerDetailsActivity contributesBasicCustomerDetailsActivity();

    @ContributesAndroidInjector
    abstract BillingAddressActivity contributesBillingAddressActivity();

    @ContributesAndroidInjector
    abstract ShippingAddressActivity contributesShippingAddressActivity();

    @ContributesAndroidInjector
    abstract CartActivity contributesCartActivity();

    @ContributesAndroidInjector
    abstract ProfileActivity contributesProfileActivity();

    @ContributesAndroidInjector
    abstract AnonymousSignInActivity contributesAnonymousSignInActivity();

    @ContributesAndroidInjector
    abstract MyOrdersActivity contributesMyOrdersActivity();

    @ContributesAndroidInjector
    abstract OrderActivity contributesOrderActivity();

}

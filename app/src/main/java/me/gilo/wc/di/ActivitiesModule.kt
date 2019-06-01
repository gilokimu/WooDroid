package me.gilo.wc.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import me.gilo.raison.ui.user.onboarding.SignInActivity
import me.gilo.raison.ui.user.onboarding.SignUpActivity
import me.gilo.wc.MainActivity
import me.gilo.wc.ui.WooDroidActivity
import me.gilo.wc.ui.customer.BasicCustomerDetailsActivity
import me.gilo.wc.ui.customer.BillingAddressActivity
import me.gilo.wc.ui.customer.ProfileActivity
import me.gilo.wc.ui.customer.ShippingAddressActivity
import me.gilo.wc.ui.home.HomeActivity
import me.gilo.wc.ui.onboarding.AnonymousSignInActivity
import me.gilo.wc.ui.order.MyOrdersActivity
import me.gilo.wc.ui.order.OrderActivity
import me.gilo.wc.ui.product.CartActivity
import me.gilo.wc.ui.product.ProductActivity
import me.gilo.wc.ui.product.ShopActivity

@Module
internal abstract class ActivitiesModule {

    @ContributesAndroidInjector
    internal abstract fun contributesMainActivity(): MainActivity

    @ContributesAndroidInjector
    internal abstract fun contributesShopActivity(): ShopActivity

    @ContributesAndroidInjector
    internal abstract fun contributesProductActivity(): ProductActivity

    @ContributesAndroidInjector
    internal abstract fun contributesHomeActivity(): HomeActivity

    @ContributesAndroidInjector
    internal abstract fun contributesSignInActivity(): SignInActivity

    @ContributesAndroidInjector
    internal abstract fun contributesSignUpActivity(): SignUpActivity

    @ContributesAndroidInjector
    internal abstract fun contributesBasicCustomerDetailsActivity(): BasicCustomerDetailsActivity

    @ContributesAndroidInjector
    internal abstract fun contributesBillingAddressActivity(): BillingAddressActivity

    @ContributesAndroidInjector
    internal abstract fun contributesShippingAddressActivity(): ShippingAddressActivity

    @ContributesAndroidInjector
    internal abstract fun contributesCartActivity(): CartActivity

    @ContributesAndroidInjector
    internal abstract fun contributesProfileActivity(): ProfileActivity

    @ContributesAndroidInjector
    internal abstract fun contributesAnonymousSignInActivity(): AnonymousSignInActivity

    @ContributesAndroidInjector
    internal abstract fun contributesMyOrdersActivity(): MyOrdersActivity

    @ContributesAndroidInjector
    internal abstract fun contributesOrderActivity(): OrderActivity

}

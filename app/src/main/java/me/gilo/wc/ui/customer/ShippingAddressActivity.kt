package me.gilo.wc.ui.customer

import android.content.Context
import android.os.Bundle
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import kotlinx.android.synthetic.main.activity_shipping_address.*
import me.gilo.wc.R
import me.gilo.wc.ui.WooDroidActivity
import me.gilo.wc.viewmodels.CustomerViewModel

class ShippingAddressActivity : WooDroidActivity<CustomerViewModel>() {

    override lateinit var viewModel : CustomerViewModel

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shipping_address)

        viewModel = getViewModel(CustomerViewModel::class.java)
        title = "Shipping Address"

    }

}

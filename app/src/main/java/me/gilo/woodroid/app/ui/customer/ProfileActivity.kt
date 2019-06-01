package me.gilo.woodroid.app.ui.customer

import android.arch.lifecycle.Observer
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.content_profile.*
import me.gilo.woodroid.app.R
import me.gilo.woodroid.app.common.Status
import me.gilo.woodroid.app.ui.WooDroidActivity
import me.gilo.woodroid.app.viewmodels.CustomerViewModel

class ProfileActivity : WooDroidActivity<CustomerViewModel>() {

    override lateinit var viewModel : CustomerViewModel

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        setSupportActionBar(toolbar)

        title = "Profile"

        tvBasicDetailsEdit.setOnClickListener{startActivity(Intent(baseContext, BasicCustomerDetailsActivity::class.java))}
        tvBillingAddressEdit.setOnClickListener{startActivity(Intent(baseContext, BillingAddressActivity::class.java))}
        tvShippingAddressEdit.setOnClickListener{startActivity(Intent(baseContext, ShippingAddressActivity::class.java))}

    }

    override fun onResume() {
        super.onResume()

        viewModel = getViewModel(CustomerViewModel::class.java)
        customer()
    }


    private fun customer() {
        viewModel.currentCustomer().observe(this, Observer {
                response->
            when (response!!.status()){
                Status.LOADING ->{
                    showLoading("Retrieve customer details", "This will only take a short while")
                }

                Status.SUCCESS ->{
                    stopShowingLoading()
                    var customer = response.data()[0]

                    tvBasicDetailsName.text = customer.firstName + " " + customer.lastName

                    tvEmail.text = "Email : " + customer.email
                    tvUsername.text = "Username : " + customer.username

                    tvShippingAddress.text = customer.shippingAddress.toString()
                    tvBillingAddress.text = customer.billingAddress.toString()

                }

                Status.ERROR ->{
                    stopShowingLoading()
                    Toast.makeText(baseContext, response.error().message.toString(), Toast.LENGTH_LONG).show()
                }

                Status.EMPTY ->{
                    stopShowingLoading()
                }

            }
        })

    }

}

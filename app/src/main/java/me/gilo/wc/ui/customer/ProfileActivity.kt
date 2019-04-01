package me.gilo.wc.ui.customer

import android.arch.lifecycle.Observer
import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import me.gilo.wc.R

import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.customer_basic_details.*
import me.gilo.wc.common.Status
import me.gilo.wc.ui.WooDroidActivity
import me.gilo.wc.viewmodels.CustomerViewModel
import java.util.regex.Matcher
import java.util.regex.Pattern

class ProfileActivity : WooDroidActivity<CustomerViewModel>() {

    override lateinit var viewModel : CustomerViewModel

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        viewModel = getViewModel(CustomerViewModel::class.java)
        title = "Profile"

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

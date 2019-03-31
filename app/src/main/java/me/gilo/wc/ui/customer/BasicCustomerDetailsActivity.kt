package me.gilo.wc.ui.customer

import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import me.gilo.wc.R

import kotlinx.android.synthetic.main.activity_basic_customer_details.*
import me.gilo.raison.ui.user.onboarding.SignInActivity
import me.gilo.wc.common.BaseActivity
import me.gilo.wc.ui.WooDroidActivity
import me.gilo.wc.ui.state.ProgressDialogFragment
import me.gilo.wc.viewmodels.CustomerViewModel
import me.gilo.wc.viewmodels.UserViewModel
import java.util.regex.Matcher
import java.util.regex.Pattern

class BasicCustomerDetailsActivity : WooDroidActivity<CustomerViewModel>() {


    override lateinit var viewModel : CustomerViewModel

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_customer_details)

        viewModel = getViewModel(CustomerViewModel::class.java)
        title = "Basic Details"

    }

}

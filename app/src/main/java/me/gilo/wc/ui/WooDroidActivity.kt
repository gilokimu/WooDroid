package me.gilo.wc.ui

import android.arch.lifecycle.ViewModel
import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import me.gilo.wc.R

import kotlinx.android.synthetic.main.activity_basic_customer_details.*
import me.gilo.raison.ui.user.onboarding.SignInActivity
import me.gilo.wc.common.BaseActivity
import me.gilo.wc.ui.state.ProgressDialogFragment
import me.gilo.wc.viewmodels.CustomerViewModel
import me.gilo.wc.viewmodels.UserViewModel
import java.util.regex.Matcher
import java.util.regex.Pattern

abstract class WooDroidActivity<T : ViewModel> : BaseActivity() {


    abstract var viewModel : T
    private lateinit var progressDialog: ProgressDialogFragment

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }

    fun showLoading() {
        showLoading("Please wait", "This will only take a second")
    }

    fun showLoading(title: String, message: String) {
        val manager = supportFragmentManager
        progressDialog = ProgressDialogFragment.newInstance(title, message)
        progressDialog.isCancelable = false
        progressDialog.show(manager, "progress")
    }

    fun stopShowingLoading() {
        progressDialog.dismiss()
    }

    fun toast(text : String){
        Toast.makeText(baseContext, text, Toast.LENGTH_LONG).show()
    }

}

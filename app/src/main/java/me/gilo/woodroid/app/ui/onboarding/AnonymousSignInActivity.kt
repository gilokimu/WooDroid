package me.gilo.woodroid.app.ui.onboarding

import android.arch.lifecycle.Observer
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import me.gilo.woodroid.app.R
import me.gilo.woodroid.app.common.Status
import me.gilo.woodroid.app.ui.WooDroidActivity
import me.gilo.woodroid.app.ui.home.HomeActivity
import me.gilo.woodroid.app.viewmodels.UserViewModel

class AnonymousSignInActivity : WooDroidActivity<UserViewModel>() {


    override lateinit var viewModel: UserViewModel

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anonymous_sign_in)

        viewModel = getViewModel(UserViewModel::class.java)
        anonymousSignIn()

    }

    private fun anonymousSignIn() {
        viewModel.anonymousSignIn().observe(this, Observer { response ->
            when (response!!.status()) {
                Status.LOADING -> {
                    showLoading("Setting you up with an account", "This will only take a short while")
                }

                Status.SUCCESS -> {
                    stopShowingLoading()
                    startActivity(Intent(baseContext, HomeActivity::class.java))

                }

                Status.ERROR -> {
                    stopShowingLoading()
                    Toast.makeText(baseContext, "Something went wrong", Toast.LENGTH_LONG).show()
                }

                Status.EMPTY -> {
                    stopShowingLoading()
                }

            }
        })

    }
}
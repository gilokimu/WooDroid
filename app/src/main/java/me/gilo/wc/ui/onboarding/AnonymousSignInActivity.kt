package me.gilo.wc.ui.onboarding

import android.arch.lifecycle.Observer
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import me.gilo.wc.R

import kotlinx.android.synthetic.main.activity_anonymous_sign_in.*
import kotlinx.android.synthetic.main.content_sign_in.*
import me.gilo.raison.ui.user.onboarding.SignUpActivity
import me.gilo.wc.common.BaseActivity
import me.gilo.wc.common.Status
import me.gilo.wc.ui.WooDroidActivity
import me.gilo.wc.ui.home.HomeActivity
import me.gilo.wc.ui.state.ProgressDialogFragment
import me.gilo.wc.viewmodels.UserViewModel
import java.util.regex.Matcher
import java.util.regex.Pattern

class AnonymousSignInActivity : WooDroidActivity<UserViewModel>() {


    override lateinit var viewModel : UserViewModel

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
            viewModel.anonymousSignIn().observe(this, Observer {
                    response->
                when (response!!.status()){
                    Status.LOADING ->{
                        showLoading("Setting you up with an account", "This will only take a short while")
                    }

                    Status.SUCCESS ->{
                        stopShowingLoading()
                        startActivity(Intent(baseContext, HomeActivity::class.java))

                    }

                    Status.ERROR ->{
                        stopShowingLoading()
                        Toast.makeText(baseContext, "Something went wrong", Toast.LENGTH_LONG).show()
                    }

                    Status.EMPTY ->{
                        stopShowingLoading()
                    }

                }
            })

    }
}
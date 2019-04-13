package me.gilo.raison.ui.user.onboarding

import android.arch.lifecycle.Observer
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.widget.Toast
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import kotlinx.android.synthetic.main.content_sign_in.*
import me.gilo.wc.R
import me.gilo.wc.common.BaseActivity
import me.gilo.wc.common.Status
import me.gilo.wc.ui.WooDroidActivity
import me.gilo.wc.ui.home.HomeActivity
import me.gilo.wc.ui.state.ProgressDialogFragment
import me.gilo.wc.viewmodels.CustomerViewModel
import me.gilo.wc.viewmodels.UserViewModel
import org.json.JSONObject
import java.util.regex.Matcher
import java.util.regex.Pattern


class SignInActivity : WooDroidActivity<UserViewModel>() {


    override lateinit var viewModel : UserViewModel

    private lateinit var progressDialog: ProgressDialogFragment
    private val pattern = Pattern.compile(EMAIL_PATTERN)
    private var matcher: Matcher? = null

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)


        viewModel = getViewModel(UserViewModel::class.java)

        title = "Sign In"

        flSignIn.setOnClickListener{
            login()
        }

        tvSignUp.setOnClickListener{startActivity(Intent(baseContext, SignUpActivity::class.java))}
    }

    private fun login() {
        if (validates()) {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            viewModel.login(email, password).observe(this, Observer {
                response->
                when (response!!.status()){
                    Status.LOADING ->{
                        showLoading("Performing log in", "This will only take a short while")
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



        } else {
            Toast.makeText(this, "Please correct the information entered", Toast.LENGTH_SHORT).show()
        }
    }

    private fun validates(): Boolean {
        var validation = true

        tilEmail.isErrorEnabled = false
        tilPassword.isErrorEnabled = false

        val email = tilEmail.editText!!.text.toString()

        if (email.isEmpty()) {
            tilEmail.error = "This cannot be left blank!"
            validation = false
        }

        return validation
    }

    private fun validateEmail(email: String): Boolean {
        matcher = pattern.matcher(email)
        return matcher!!.matches()
    }

    companion object {
        private const val EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$"
    }

}

package me.gilo.raison.ui.user.onboarding

import android.arch.lifecycle.Observer
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.widget.Toast
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import kotlinx.android.synthetic.main.content_sign_up.*
import me.gilo.wc.R
import me.gilo.wc.common.BaseActivity
import me.gilo.wc.common.Status

import me.gilo.wc.models.User
import me.gilo.wc.ui.WooDroidActivity
import me.gilo.wc.ui.home.HomeActivity
import me.gilo.wc.ui.state.ProgressDialogFragment
import me.gilo.wc.viewmodels.UserViewModel
import java.util.regex.Matcher
import java.util.regex.Pattern

class SignUpActivity : WooDroidActivity<UserViewModel>() {

    override lateinit var viewModel : UserViewModel
    val TAG = this::getLocalClassName

    private lateinit var progressDialog: ProgressDialogFragment
    private val pattern = Pattern.compile(EMAIL_PATTERN)
    private var matcher: Matcher? = null

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        viewModel = getViewModel(UserViewModel::class.java)

        title = "Sign Up"

        flSignup.setOnClickListener{
            signUp()
        }

    }

    private fun signUp() {
        if (validates()) {
            val email = etEmail.text.toString()
            val firstName =  etFirstName.text.toString()
            val lastName = etLastName.text.toString()
            val password = etPassword.text.toString()

            var user = User()
            user.email = email
            user.firstname = firstName
            user.lastname = lastName

           viewModel.signUp(email, password).observe(this, Observer {
                   response->
               when (response!!.status()){
                   Status.LOADING ->{
                       showLoading("Uploading account details", "This will only take a short while")
                   }

                   Status.SUCCESS ->{
                       stopShowingLoading()
                       startActivity(Intent(baseContext, HomeActivity::class.java))
                   }

                   Status.ERROR ->{
                       stopShowingLoading()
                       Toast.makeText(baseContext, response.error().message.toString(), Toast.LENGTH_LONG).show()
                   }

                   Status.EMPTY ->{

                   }

               }
           })



        } else {
            Toast.makeText(this, "Please correct the information entered", Toast.LENGTH_SHORT).show()
        }
    }

    private fun sendDetails() {
        if (validates()) {
            val email = etEmail.text.toString()
           val firstName =  etFirstName.text.toString()
            val lastName = etLastName.text.toString()

           var user = User()
            user.email = email
            user.firstname = firstName
            user.lastname = lastName

            viewModel.updateUser(user).observe(this, Observer {
                response->
                when (response!!.status()){
                    Status.LOADING ->{
                        showLoading("Uploading account details", "This will only take a short while")
                    }

                    Status.SUCCESS ->{
                        stopShowingLoading()
                        startActivity(Intent(baseContext, HomeActivity::class.java))
                    }

                    Status.ERROR ->{
                        stopShowingLoading()
                       Toast.makeText(baseContext, response.error().message.toString(), Toast.LENGTH_LONG).show()
                    }

                    Status.EMPTY ->{

                    }

                }
            })



        } else {
            Toast.makeText(this, "Please correct the information entered", Toast.LENGTH_SHORT).show()
        }
    }

    private fun validates(): Boolean {
        tilEmail.isErrorEnabled = false
        tilFirstName.isErrorEnabled = false
        tilLastName.isErrorEnabled = false
        tilPassword.isErrorEnabled = false
        tilPasswordVerify.isErrorEnabled = false

        var validation = true

        val email = tilEmail.editText!!.text.toString()
        val firstName =  etFirstName.text.toString()
        val lastName = etLastName.text.toString()
        val password = etPassword.text.toString()
        val passwordVerify = etPasswordVerify.text.toString()



        if (!validateEmail(email)) {
            tilEmail.error = "Not a valid email address!"
            validation = false
        }

        if (firstName.isEmpty()) {
            tilFirstName.error = "Please fill this"
            validation = false
        }

        if (lastName.isEmpty()) {
            tilLastName.error = "Please fill this"
            validation = false
        }

        if (password.isEmpty()) {
            tilPassword.error = "Please fill this"
            validation = false
        }

        if (passwordVerify.isEmpty()) {
            tilPasswordVerify.error = "Please fill this"
            validation = false
        }

        if (passwordVerify != password) {
            tilPasswordVerify.error = "Passwords do not match"
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

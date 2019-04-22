package me.gilo.wc.ui.customer

import android.arch.lifecycle.Observer
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import kotlinx.android.synthetic.main.customer_basic_details.*
import me.gilo.wc.R
import me.gilo.wc.common.Status
import me.gilo.wc.models.User
import me.gilo.wc.ui.WooDroidActivity
import me.gilo.wc.ui.home.HomeActivity
import me.gilo.wc.viewmodels.CustomerViewModel
import me.gilo.woodroid.models.Customer
import java.util.regex.Matcher
import java.util.regex.Pattern

class BasicCustomerDetailsActivity : WooDroidActivity<CustomerViewModel>() {


    override lateinit var viewModel: CustomerViewModel
    private val pattern = Pattern.compile(EMAIL_PATTERN)
    private var matcher: Matcher? = null
    lateinit var customer: Customer

    var newCustomer = false

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_customer_details)

        viewModel = getViewModel(CustomerViewModel::class.java)
        title = "Basic Details"

        customer()

        flSave.setOnClickListener {
            if (newCustomer) {
                create()
            } else {
                save()
            }
        }

    }


    private fun customer() {
        viewModel.currentCustomer().observe(this, Observer { response ->
            when (response!!.status()) {
                Status.LOADING -> {
                    showLoading("Retrieve customer details", "This will only take a short while")
                }

                Status.SUCCESS -> {
                    stopShowingLoading()
                    customer = response.data()[0]

                    etEmail.setText(customer.email)
                    etFirstName.setText(customer.firstName)
                    etLastName.setText(customer.lastName)
                    etUsername.setText(customer.username)

                    newCustomer = false
                }

                Status.ERROR -> {
                    stopShowingLoading()
                    Toast.makeText(baseContext, response.error().message.toString(), Toast.LENGTH_LONG).show()
                }

                Status.EMPTY -> {
                    stopShowingLoading()

                    newCustomer = true
                }

            }
        })

    }

    private fun save() {
        if (validates()) {
            val email = etEmail.text.toString()
            val firstName = etFirstName.text.toString()
            val lastName = etLastName.text.toString()
            val username = etUsername.text.toString()

            customer.email = email
            customer.firstName = firstName
            customer.lastName = lastName
            customer.username = username

            viewModel.update(customer.id, customer).observe(this, Observer { response ->
                when (response!!.status()) {
                    Status.LOADING -> {
                        showLoading("Uploading account details", "This will only take a short while")
                    }

                    Status.SUCCESS -> {
                        stopShowingLoading()
                        finish()
                    }

                    Status.ERROR -> {
                        stopShowingLoading()
                        Toast.makeText(baseContext, response.error().message.toString(), Toast.LENGTH_LONG).show()
                    }

                    Status.EMPTY -> {

                    }

                }
            })


        } else {
            Toast.makeText(this, "Please correct the information entered", Toast.LENGTH_SHORT).show()
        }
    }

    private fun create() {
        if (validates()) {
            val email = etEmail.text.toString()
            val firstName = etFirstName.text.toString()
            val lastName = etLastName.text.toString()
            val username = etUsername.text.toString()

            var customer = Customer()
            customer.email = email
            customer.firstName = firstName
            customer.lastName = lastName
            customer.username = username

            viewModel.create(customer).observe(this, Observer { response ->
                when (response!!.status()) {
                    Status.LOADING -> {
                        showLoading("Uploading account details", "This will only take a short while")
                    }

                    Status.SUCCESS -> {
                        stopShowingLoading()
                        finish()
                    }

                    Status.ERROR -> {
                        stopShowingLoading()
                        Toast.makeText(baseContext, response.error().message.toString(), Toast.LENGTH_LONG).show()
                    }

                    Status.EMPTY -> {

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
        tilUsername.isErrorEnabled = false

        var validation = true

        val email = tilEmail.editText!!.text.toString()
        val firstName = etFirstName.text.toString()
        val lastName = etLastName.text.toString()
        val username = etUsername.text.toString()



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

        return validation
    }

    private fun validateEmail(email: String): Boolean {
        matcher = pattern.matcher(email)
        return matcher!!.matches()
    }

    companion object {
        private const val EMAIL_PATTERN =
            "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$"
    }

}

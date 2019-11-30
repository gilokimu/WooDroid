package me.gilo.woodroid.app.ui.customer

import androidx.lifecycle.Observer
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import kotlinx.android.synthetic.main.customer_basic_details.*
import me.gilo.woodroid.app.R
import me.gilo.woodroid.app.common.Status
import me.gilo.woodroid.app.ui.WooDroidActivity
import me.gilo.woodroid.app.viewmodels.CustomerViewModel
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

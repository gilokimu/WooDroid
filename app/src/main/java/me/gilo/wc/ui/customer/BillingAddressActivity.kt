package me.gilo.wc.ui.customer

import android.arch.lifecycle.Observer
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import kotlinx.android.synthetic.main.customer_billing_address.*
import kotlinx.android.synthetic.main.drawer_filter.view.*
import me.gilo.wc.R
import me.gilo.wc.common.Status
import me.gilo.wc.ui.WooDroidActivity
import me.gilo.wc.viewmodels.CustomerViewModel
import me.gilo.woodroid.models.BillingAddress
import me.gilo.woodroid.models.Customer

class BillingAddressActivity : WooDroidActivity<CustomerViewModel>() {

    override lateinit var viewModel : CustomerViewModel
    lateinit var customer : Customer

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_billing_address)

        viewModel = getViewModel(CustomerViewModel::class.java)
        title = "Billing Address"

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
                    customer = response.data()[0]

                    if (customer.billingAddress != null) {
                        etFirstName.setText(customer.billingAddress.firstName)
                        etLastName.setText(customer.billingAddress.firstName)
                        etCompany.setText(customer.billingAddress.company)
                        etStreetAddress.setText(customer.billingAddress.address1)
                        etStreetAddress2.setText(customer.billingAddress.address2)
                        etCity.setText(customer.billingAddress.city)
                        etState.setText(customer.billingAddress.state)
                        etZipcode.setText(customer.billingAddress.postcode)
                        etCountry.setText(customer.billingAddress.country)
                        etPhone.setText(customer.billingAddress.phone)
                    }else{
                        etFirstName.setText(customer.firstName)
                        etLastName.setText(customer.firstName)
                    }
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

        flSave.setOnClickListener{save()}

    }

    private fun save() {
        if (validates()) {
            val firstName =  etFirstName.text.toString()
            val lastName = etLastName.text.toString()
            val company = etCompany.text.toString()
            val streetAddress =  etStreetAddress.text.toString()
            val streetAddress2 =  etStreetAddress2.text.toString()
            val city = etCity.text.toString()
            val state = etState.text.toString()
            val zipcode =  etZipcode.text.toString()
            val country = etCountry.text.toString()
            val phone =  etPhone.text.toString()

            customer.billingAddress = BillingAddress()

            customer.billingAddress.firstName = firstName
            customer.billingAddress.lastName = lastName
            customer.billingAddress.company = company
            customer.billingAddress.address1 = streetAddress
            customer.billingAddress.address2 = streetAddress2

            customer.billingAddress.city = city
            customer.billingAddress.state = state
            customer.billingAddress.postcode = zipcode
            customer.billingAddress.country = country
            customer.billingAddress.phone = phone

            customer.billingAddress.email = FirebaseAuth.getInstance().currentUser!!.email

            viewModel.update(customer.id, customer).observe(this, Observer {
                    response->
                when (response!!.status()){
                    Status.LOADING ->{
                        showLoading("Uploading account details", "This will only take a short while")
                    }

                    Status.SUCCESS ->{
                        stopShowingLoading()
                       finish()
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
        tilFirstName.isErrorEnabled = false
        tilLastName.isErrorEnabled = false
        tilStreetAddress.isErrorEnabled = false
        tilCity.isErrorEnabled = false
        tilZipcode.isErrorEnabled = false
        tilCountry.isErrorEnabled = false
        tilPhone.isErrorEnabled = false

        var validation = true

        val firstName =  etFirstName.text.toString()
        val lastName = etLastName.text.toString()
        val streetAddress =  etStreetAddress.text.toString()
        val city = etCity.text.toString()
        val zipcode =  etZipcode.text.toString()
        val country = etCountry.text.toString()
        val phone =  etPhone.text.toString()

        if (firstName.isEmpty()) {
            tilFirstName.error = "Please fill this"
            validation = false
        }

        if (lastName.isEmpty()) {
            tilLastName.error = "Please fill this"
            validation = false
        }

        if (streetAddress.isEmpty()) {
            tilStreetAddress.error = "Please fill this"
            validation = false
        }

        if (city.isEmpty()) {
            tilCity.error = "Please fill this"
            validation = false
        }

        if (zipcode.isEmpty()) {
            tilZipcode.error = "Please fill this"
            validation = false
        }

        if (country.isEmpty()) {
            tilCountry.error = "Please fill this"
            validation = false
        }

        if (phone.isEmpty()) {
            tilPhone.error = "Please fill this"
            validation = false
        }


        return validation
    }

}

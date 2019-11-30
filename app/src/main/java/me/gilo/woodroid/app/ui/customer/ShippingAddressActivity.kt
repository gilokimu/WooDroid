package me.gilo.woodroid.app.ui.customer

import androidx.lifecycle.Observer
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import kotlinx.android.synthetic.main.customer_shipping_address.*
import me.gilo.woodroid.app.R
import me.gilo.woodroid.app.common.Status
import me.gilo.woodroid.app.ui.WooDroidActivity
import me.gilo.woodroid.app.viewmodels.CustomerViewModel
import me.gilo.woodroid.models.Customer
import me.gilo.woodroid.models.ShippingAddress

class ShippingAddressActivity : WooDroidActivity<CustomerViewModel>() {

    override lateinit var viewModel : CustomerViewModel
    lateinit var customer : Customer

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shipping_address)

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

                    if (customer.shippingAddress != null) {
                        etFirstName.setText(customer.shippingAddress.firstName)
                        etLastName.setText(customer.shippingAddress.firstName)
                        etCompany.setText(customer.shippingAddress.company)
                        etStreetAddress.setText(customer.shippingAddress.address1)
                        etStreetAddress2.setText(customer.shippingAddress.address2)
                        etCity.setText(customer.shippingAddress.city)
                        etState.setText(customer.shippingAddress.state)
                        etZipcode.setText(customer.shippingAddress.postcode)
                        etCountry.setText(customer.shippingAddress.country)
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

            customer.shippingAddress = ShippingAddress()

            customer.shippingAddress.firstName = firstName
            customer.shippingAddress.lastName = lastName
            customer.shippingAddress.company = company
            customer.shippingAddress.address1 = streetAddress
            customer.shippingAddress.address2 = streetAddress2

            customer.shippingAddress.city = city
            customer.shippingAddress.state = state
            customer.shippingAddress.postcode = zipcode
            customer.shippingAddress.country = country

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

        var validation = true

        val firstName =  etFirstName.text.toString()
        val lastName = etLastName.text.toString()
        val streetAddress =  etStreetAddress.text.toString()
        val city = etCity.text.toString()
        val zipcode =  etZipcode.text.toString()
        val country = etCountry.text.toString()

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

        return validation
    }

}

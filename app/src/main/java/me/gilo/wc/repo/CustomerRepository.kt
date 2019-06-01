package me.gilo.wc.repo


import com.google.firebase.auth.FirebaseAuth
import me.gilo.wc.common.WooLiveData
import me.gilo.woodroid.Woocommerce
import me.gilo.woodroid.models.Customer
import me.gilo.woodroid.models.filters.CustomerFilter

import javax.inject.Inject

class CustomerRepository @Inject
constructor() {

    @Inject
    lateinit var woocommerce: Woocommerce

    fun create(customer: Customer): WooLiveData<Customer> {
        val callBack = WooLiveData<Customer>()
        woocommerce!!.CustomerRepository().create(customer).enqueue(callBack)
        return callBack
    }

    fun currentCustomer(): WooLiveData<List<Customer>> {
        val callBack = WooLiveData<List<Customer>>()
        val customerFilter = CustomerFilter()
        customerFilter.email = FirebaseAuth.getInstance().currentUser!!.email

        woocommerce!!.CustomerRepository().customers(customerFilter).enqueue(callBack)
        return callBack
    }


    fun customer(id: Int): WooLiveData<Customer> {
        val callBack = WooLiveData<Customer>()
        woocommerce!!.CustomerRepository().customer(id).enqueue(callBack)
        return callBack
    }

    fun customers(): WooLiveData<List<Customer>> {
        val callBack = WooLiveData<List<Customer>>()

        woocommerce!!.CustomerRepository().customers().enqueue(callBack)

        return callBack
    }

    fun customers(customerFilter: CustomerFilter): WooLiveData<List<Customer>> {
        val callBack = WooLiveData<List<Customer>>()
        woocommerce!!.CustomerRepository().customers(customerFilter).enqueue(callBack)
        return callBack
    }

    fun update(id: Int, customer: Customer): WooLiveData<Customer> {
        val callBack = WooLiveData<Customer>()
        woocommerce!!.CustomerRepository().update(id, customer).enqueue(callBack)

        return callBack
    }

    fun delete(id: Int): WooLiveData<Customer> {
        val callBack = WooLiveData<Customer>()
        woocommerce!!.CustomerRepository().delete(id).enqueue(callBack)

        return callBack
    }

    fun delete(id: Int, force: Boolean): WooLiveData<Customer> {
        val callBack = WooLiveData<Customer>()
        woocommerce!!.CustomerRepository().delete(id, force).enqueue(callBack)

        return callBack
    }


}

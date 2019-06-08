package me.gilo.woodroid.repo

import me.gilo.woodroid.data.api.CustomerAPI
import me.gilo.woodroid.models.Customer
import me.gilo.woodroid.models.filters.CustomerFilter
import retrofit2.Call

class CustomerRepository(baseUrl: String, consumerKey: String, consumerSecret: String) :
    WooRepository(baseUrl, consumerKey, consumerSecret) {

    private val apiService: CustomerAPI

    init {
        apiService = retrofit.create(CustomerAPI::class.java)
    }

    fun create(customer: Customer): Call<Customer> {
        return apiService.create(customer)
    }


    fun customer(id: Int): Call<Customer> {
        return apiService.view(id)
    }

    fun customers(): Call<List<Customer>> {
        return apiService.list()
    }

    fun customers(customerFilter: CustomerFilter): Call<List<Customer>> {
        return apiService.filter(customerFilter.filters)
    }

    fun update(id: Int, customer: Customer): Call<Customer> {
        return apiService.update(id, customer)
    }

    fun delete(id: Int): Call<Customer> {
        return apiService.delete(id)
    }

    fun delete(id: Int, force: Boolean): Call<Customer> {
        return apiService.delete(id, force)
    }


}

package me.gilo.woodroid.repo

import retrofit2.Call

import me.gilo.woodroid.data.api.PaymentGatewayAPI
import me.gilo.woodroid.models.PaymentGateway

class PaymentGatewayRepository(baseUrl: String, consumerKey: String, consumerSecret: String) :
    WooRepository(baseUrl, consumerKey, consumerSecret) {

    private val apiService: PaymentGatewayAPI

    init {
        apiService = retrofit.create(PaymentGatewayAPI::class.java)
    }

    fun paymentGateway(id: Int): Call<PaymentGateway> {
        return apiService.view(id)
    }

    fun paymentGateways(): Call<List<PaymentGateway>> {
        return apiService.list()
    }

    fun update(id: String, paymentGateway: PaymentGateway): Call<PaymentGateway> {
        return apiService.update(id, paymentGateway)
    }

}

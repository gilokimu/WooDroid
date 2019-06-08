package me.gilo.woodroid.repo.order

import me.gilo.woodroid.data.api.OrderNoteAPI
import me.gilo.woodroid.models.Order
import me.gilo.woodroid.models.OrderNote
import me.gilo.woodroid.models.filters.OrderNoteFilter
import me.gilo.woodroid.repo.WooRepository
import retrofit2.Call

class OrderNoteRepository(baseUrl: String, consumerKey: String, consumerSecret: String) :
    WooRepository(baseUrl, consumerKey, consumerSecret) {

    private val apiService: OrderNoteAPI

    init {
        apiService = retrofit.create(OrderNoteAPI::class.java)
    }

    fun create(order: Order, note: OrderNote): Call<OrderNote> {
        return apiService.create(order.getId()!!, note)
    }

    fun note(order: Order, id: Int): Call<OrderNote> {
        return apiService.view(order.getId()!!, id)
    }

    fun notes(order: Order): Call<List<OrderNote>> {
        return apiService.list(order.getId()!!)
    }

    fun notes(order: Order, orderNoteFilter: OrderNoteFilter): Call<List<OrderNote>> {
        return apiService.filter(order.getId()!!, orderNoteFilter.filters)
    }

    fun delete(order: Order, id: Int): Call<OrderNote> {
        return apiService.delete(order.getId()!!, id)
    }

    fun delete(order: Order, id: Int, force: Boolean): Call<OrderNote> {
        return apiService.delete(order.getId()!!, id, force)
    }


}

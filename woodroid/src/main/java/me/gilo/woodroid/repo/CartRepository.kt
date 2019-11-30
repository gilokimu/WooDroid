package me.gilo.woodroid.repo

import me.gilo.cocart.model.CartItem
import me.gilo.cocart.repo.CoCartRepository
import retrofit2.Call

class CartRepository(internal var baseUrl: String, consumerKey: String, consumerSecret: String) {

    private var cartRepository: CoCartRepository = CoCartRepository(baseUrl, consumerKey, consumerSecret)

    fun addToCart(productId: Int, quantity: Int): Call<Map<String, CartItem>> {
        return cartRepository.addToCart(productId, quantity)
    }

}

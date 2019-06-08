package me.gilo.woodroid.repo.product

import me.gilo.woodroid.data.api.ProductVariationAPI
import me.gilo.woodroid.models.Variation
import me.gilo.woodroid.models.filters.ProductVariationFilter
import me.gilo.woodroid.repo.WooRepository
import retrofit2.Call

class VariationRepository(baseUrl: String, consumerKey: String, consumerSecret: String) :
    WooRepository(baseUrl, consumerKey, consumerSecret) {

    private val apiService: ProductVariationAPI

    init {
        apiService = retrofit.create(ProductVariationAPI::class.java)
    }

    fun create(product_id: Int, variation: Variation): Call<Variation> {
        return apiService.create(product_id, variation)
    }


    fun variation(product_id: Int, id: Int): Call<Variation> {
        return apiService.view(product_id, id)
    }

    fun variations(product_id: Int): Call<List<Variation>> {
        return apiService.list(product_id)
    }

    fun variations(product_id: Int, productVariationFilter: ProductVariationFilter): Call<List<Variation>> {
        return apiService.filter(product_id, productVariationFilter.filters)
    }

    fun update(product_id: Int, id: Int, variation: Variation): Call<Variation> {
        return apiService.update(product_id, id, variation)
    }

    fun delete(product_id: Int, id: Int): Call<Variation> {
        return apiService.delete(product_id, id)
    }

    fun delete(product_id: Int, id: Int, force: Boolean): Call<Variation> {
        return apiService.delete(product_id, id, force)
    }

}

package me.gilo.woodroid.repo.product

import me.gilo.woodroid.data.api.ProductAttributeTermAPI
import me.gilo.woodroid.models.AttributeTerm
import me.gilo.woodroid.models.filters.ProductAttributeFilter
import me.gilo.woodroid.repo.WooRepository
import retrofit2.Call

class AttributeTermRepository(baseUrl: String, consumerKey: String, consumerSecret: String) :
    WooRepository(baseUrl, consumerKey, consumerSecret) {

    private val apiService: ProductAttributeTermAPI = retrofit.create(ProductAttributeTermAPI::class.java)

    fun create(attribute_id: Int, term: AttributeTerm): Call<AttributeTerm> {
        return apiService.create(attribute_id, term)
    }

    fun term(attribute_id: Int, id: Int): Call<AttributeTerm> {
        return apiService.view(attribute_id, id)
    }

    fun terms(attribute_id: Int): Call<List<AttributeTerm>> {
        return apiService.list(attribute_id)
    }

    fun terms(attribute_id: Int, productAttributeFilter: ProductAttributeFilter): Call<List<AttributeTerm>> {
        return apiService.filter(attribute_id, productAttributeFilter.filters)
    }

    fun update(attribute_id: Int, id: Int, term: AttributeTerm): Call<AttributeTerm> {
        return apiService.update(attribute_id, id, term)
    }

    fun delete(attribute_id: Int, id: Int): Call<AttributeTerm> {
        return apiService.delete(attribute_id, id)
    }

    fun delete(attribute_id: Int, id: Int, force: Boolean): Call<AttributeTerm> {
        return apiService.delete(attribute_id, id, force)
    }


}

package me.gilo.woodroid.repo.product

import me.gilo.woodroid.data.api.ProductAttributeAPI
import me.gilo.woodroid.models.Attribute
import me.gilo.woodroid.models.filters.ProductAttributeFilter
import me.gilo.woodroid.repo.WooRepository
import retrofit2.Call

class AttributeRepository(baseUrl: String, consumerKey: String, consumerSecret: String) :
    WooRepository(baseUrl, consumerKey, consumerSecret) {

    private val apiService: ProductAttributeAPI

    init {
        apiService = retrofit.create(ProductAttributeAPI::class.java)
    }

    fun create(attribute: Attribute): Call<Attribute> {
        return apiService.create(attribute)
    }


    fun attribute(id: Int): Call<Attribute> {
        return apiService.view(id)
    }

    fun attributes(): Call<List<Attribute>> {
        return apiService.list()
    }

    fun attributes(productAttributeFilter: ProductAttributeFilter): Call<List<Attribute>> {
        return apiService.filter(productAttributeFilter.filters)
    }

    fun update(id: Int, attribute: Attribute): Call<Attribute> {
        return apiService.update(id, attribute)
    }

    fun delete(id: Int): Call<Attribute> {
        return apiService.delete(id)
    }

    fun delete(id: Int, force: Boolean): Call<Attribute> {
        return apiService.delete(id, force)
    }


}

package me.gilo.woodroid.repo.product

import me.gilo.woodroid.data.api.ProductAttributeAPI
import me.gilo.woodroid.models.ProductAttribute
import me.gilo.woodroid.models.filters.ProductAttributeFilter
import me.gilo.woodroid.repo.WooRepository
import retrofit2.Call

class AttributeRepository(baseUrl: String, consumerKey: String, consumerSecret: String) :
    WooRepository(baseUrl, consumerKey, consumerSecret) {

    private val apiService: ProductAttributeAPI = retrofit.create(ProductAttributeAPI::class.java)

    fun create(productAttribute: ProductAttribute): Call<ProductAttribute> {
        return apiService.create(productAttribute)
    }


    fun attribute(id: Int): Call<ProductAttribute> {
        return apiService.view(id)
    }

    fun attributes(): Call<List<ProductAttribute>> {
        return apiService.list()
    }

    fun attributes(productAttributeFilter: ProductAttributeFilter): Call<List<ProductAttribute>> {
        return apiService.filter(productAttributeFilter.filters)
    }

    fun update(id: Int, productAttribute: ProductAttribute): Call<ProductAttribute> {
        return apiService.update(id, productAttribute)
    }

    fun delete(id: Int): Call<ProductAttribute> {
        return apiService.delete(id)
    }

    fun delete(id: Int, force: Boolean): Call<ProductAttribute> {
        return apiService.delete(id, force)
    }


}

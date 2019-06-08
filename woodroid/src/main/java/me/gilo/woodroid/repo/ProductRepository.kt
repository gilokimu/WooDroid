package me.gilo.woodroid.repo

import me.gilo.woodroid.data.api.ProductAPI
import me.gilo.woodroid.models.Product
import me.gilo.woodroid.models.filters.ProductFilter
import retrofit2.Call

import java.util.HashMap

class ProductRepository(baseUrl: String, consumerKey: String, consumerSecret: String) :
    WooRepository(baseUrl, consumerKey, consumerSecret) {

    private val apiService: ProductAPI

    init {
        apiService = retrofit.create(ProductAPI::class.java)
    }

    fun create(product: Product): Call<Product> {
        return apiService.create(product)
    }


    fun product(id: Int): Call<Product> {
        return apiService.view(id)
    }

    fun products(): Call<List<Product>> {
        return apiService.list()
    }

    fun filter(filters: Map<String, String>): Call<List<Product>> {
        return apiService.filter(filters)
    }

    fun products(productFilter: ProductFilter): Call<List<Product>> {
        return filter(productFilter.filters)
    }

    fun search(term: String): Call<List<Product>> {
        val productFilter = ProductFilter()
        productFilter.search = term

        return filter(productFilter.filters)
    }

    fun products(page: Int, per_page: Int): Call<List<Product>> {
        val productFilter = ProductFilter()
        productFilter.page = page
        productFilter.per_page = per_page

        return filter(productFilter.filters)
    }

    fun products(page: Int): Call<List<Product>> {
        val productFilter = ProductFilter()
        productFilter.page = page

        return filter(productFilter.filters)
    }

    fun update(id: Int, product: Product): Call<Product> {
        return apiService.update(id, product)
    }

    fun delete(id: Int): Call<Product> {
        return apiService.delete(id)
    }

    fun delete(id: Int, force: Boolean): Call<Product> {
        return apiService.delete(id, force)
    }

    fun products(filters: HashMap<String, String>): Call<List<Product>> {
        return apiService.filter(filters)
    }


}

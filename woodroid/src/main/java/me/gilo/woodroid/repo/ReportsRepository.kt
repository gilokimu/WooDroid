package me.gilo.woodroid.repo

import me.gilo.woodroid.data.api.ReportAPI
import me.gilo.woodroid.models.filters.ReportsDateFilter
import me.gilo.woodroid.models.report.*
import retrofit2.Call

class ReportsRepository(baseUrl: String, consumerKey: String, consumerSecret: String) :
    WooRepository(baseUrl, consumerKey, consumerSecret) {

    private val apiService: ReportAPI

    init {
        apiService = retrofit.create(ReportAPI::class.java)
    }

    fun sales(): Call<List<SalesTotal>> {
        return apiService.sales()
    }

    fun sales(reportsDateFilter: ReportsDateFilter): Call<List<SalesTotal>> {
        return apiService.sales(reportsDateFilter.filters)
    }

    fun top_sellers(): Call<List<TopSellerProducts>> {
        return apiService.top_sellers()
    }

    fun top_sellers(reportsDateFilter: ReportsDateFilter): Call<List<TopSellerProducts>> {
        return apiService.top_sellers(reportsDateFilter.filters)
    }

    fun coupons_totals(): Call<List<CouponsTotal>> {
        return apiService.coupons_totals()
    }

    fun customer_totals(): Call<List<CustomersTotal>> {
        return apiService.customers_totals()
    }

    fun order_totals(): Call<List<OrdersTotal>> {
        return apiService.orders_totals()
    }

    fun product_totals(): Call<List<ProductsTotal>> {
        return apiService.products_totals()
    }

    fun review_totals(): Call<List<ReviewsTotal>> {
        return apiService.reviews_totals()
    }

}

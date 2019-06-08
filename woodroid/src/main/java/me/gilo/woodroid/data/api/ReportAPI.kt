package me.gilo.woodroid.data.api


import me.gilo.woodroid.models.report.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ReportAPI {

    @GET("reports/sales")
    fun sales(): Call<List<SalesTotal>>

    @GET("reports/sales")
    fun sales(@QueryMap filter: Map<String, String>): Call<List<SalesTotal>>


    @GET("reports/top_sellers")
    fun top_sellers(): Call<List<TopSellerProducts>>

    @GET(" /wp-json/wc/v3/reports/top_sellers")
    fun top_sellers(@QueryMap filter: Map<String, String>): Call<List<TopSellerProducts>>


    @GET("reports/coupons/totals")
    fun coupons_totals(): Call<List<CouponsTotal>>


    @GET("reports/customers/totals")
    fun customers_totals(): Call<List<CustomersTotal>>


    @GET("reports/orders/totals")
    fun orders_totals(): Call<List<OrdersTotal>>

    @GET("reports/products/totals")
    fun products_totals(): Call<List<ProductsTotal>>

    @GET("reports/reviews/totals")
    fun reviews_totals(): Call<List<ReviewsTotal>>

}
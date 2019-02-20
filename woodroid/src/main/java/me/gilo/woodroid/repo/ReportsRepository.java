package me.gilo.woodroid.repo;

import me.gilo.woodroid.data.api.ReportAPI;
import me.gilo.woodroid.models.filters.ReportsDateFilter;
import me.gilo.woodroid.models.report.*;
import retrofit2.Call;

import java.util.List;

public class ReportsRepository extends WooRepository{

    private final ReportAPI apiService;

    public ReportsRepository(String baseUrl, String consumerKey, String consumerSecret) {
       super( baseUrl, consumerKey, consumerSecret);
       apiService = retrofit.create(ReportAPI.class);
    }

    public Call<List<SalesTotal>> sales() {
        return apiService.sales();
    }

    public Call<List<SalesTotal>> sales(ReportsDateFilter reportsDateFilter) {
        return apiService.sales(reportsDateFilter.getFilters());
    }

    public Call<List<TopSellerProducts>> top_sellers() {
        return apiService.top_sellers();
    }

    public Call<List<TopSellerProducts>> top_sellers(ReportsDateFilter reportsDateFilter) {
        return apiService.top_sellers(reportsDateFilter.getFilters());
    }

    public Call<List<CouponsTotal>> coupons_totals() {
        return apiService.coupons_totals();
    }

    public Call<List<CustomersTotal>> customer_totals() {
        return apiService.customers_totals();
    }

    public Call<List<OrdersTotal>> order_totals() {
        return apiService.orders_totals();
    }

    public Call<List<ProductsTotal>> product_totals() {
        return apiService.products_totals();
    }

    public Call<List<ReviewsTotal>> review_totals() {
        return apiService.reviews_totals();
    }

}

package me.gilo.woodroid.data.api;


import me.gilo.woodroid.models.report.*;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

import java.util.List;
import java.util.Map;

public interface ReportAPI {

    @GET("reports/sales")
    Call<List<SalesTotal>> sales();

    @GET("reports/sales")
    Call<List<SalesTotal>> sales(@QueryMap Map<String, String> filter);


    @GET("reports/top_sellers")
    Call<List<TopSellerProducts>> top_sellers();

    @GET(" /wp-json/wc/v3/reports/top_sellers")
    Call<List<TopSellerProducts>> top_sellers(@QueryMap Map<String, String> filter);


    @GET("reports/coupons/totals")
    Call<List<CouponsTotal>> coupons_totals();


    @GET("reports/customers/totals")
    Call<List<CustomersTotal>> customers_totals();


    @GET("reports/orders/totals")
    Call<List<OrdersTotal>> orders_totals();

    @GET("reports/products/totals")
    Call<List<ProductsTotal>> products_totals();

    @GET("reports/reviews/totals")
    Call<List<ReviewsTotal>> reviews_totals();

}
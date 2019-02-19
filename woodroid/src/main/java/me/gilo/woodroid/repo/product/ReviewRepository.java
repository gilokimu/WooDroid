package me.gilo.woodroid.repo.product;

import me.gilo.woodroid.data.api.ProductReviewAPI;
import me.gilo.woodroid.models.ProductReview;
import me.gilo.woodroid.models.filters.ProductReviewFilter;
import me.gilo.woodroid.repo.WooRepository;
import retrofit2.Call;

import java.util.List;

public class ReviewRepository extends WooRepository {

    private final ProductReviewAPI apiService;

    public ReviewRepository(String baseUrl, String consumerKey, String consumerSecret) {
       super(baseUrl, consumerKey, consumerSecret);
       apiService = retrofit.create(ProductReviewAPI.class);
    }

    public Call<ProductReview> create(ProductReview review) {
        return apiService.create(review);
    }


    public Call<ProductReview> review(int id) {
        return apiService.view(id);
    }

    public Call<List<ProductReview>> reviews() {
        return apiService.list();
    }

    public Call<List<ProductReview>> reviews(ProductReviewFilter productReviewFilter) {
        return apiService.filter(productReviewFilter.getFilters());
    }

    public Call<ProductReview> update(int id, ProductReview review) {
        return apiService.update(id, review);
    }

    public Call<ProductReview> delete(int id) {
        return apiService.delete(id);
    }

    public Call<ProductReview> delete(int id, boolean force) {
        return apiService.delete(id, force);
    }


}

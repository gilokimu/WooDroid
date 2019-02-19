package me.gilo.woodroid.repo.product;

import me.gilo.woodroid.data.api.ProductVariationAPI;
import me.gilo.woodroid.models.Variation;
import me.gilo.woodroid.models.filters.ProductVariationFilter;
import me.gilo.woodroid.repo.WooRepository;
import retrofit2.Call;

import java.util.List;

public class VariationRepository extends WooRepository {

    private final ProductVariationAPI apiService;

    public VariationRepository(String baseUrl, String consumerKey, String consumerSecret) {
       super(baseUrl, consumerKey, consumerSecret);
       apiService = retrofit.create(ProductVariationAPI.class);
    }

    public Call<Variation> create(int product_id, Variation variation) {
        return apiService.create(product_id, variation);
    }


    public Call<Variation> variation(int product_id, int id) {
        return apiService.view(product_id, id);
    }

    public Call<List<Variation>> variations(int product_id) {
        return apiService.list(product_id);
    }

    public Call<List<Variation>> variations(int product_id, ProductVariationFilter productVariationFilter) {
        return apiService.filter(product_id, productVariationFilter.getFilters());
    }

    public Call<Variation> update(int product_id, int id, Variation variation) {
        return apiService.update(product_id, id, variation);
    }

    public Call<Variation> delete(int product_id, int id) {
        return apiService.delete(product_id, id);
    }

    public Call<Variation> delete(int product_id, int id, boolean force) {
        return apiService.delete(product_id, id, force);
    }

}

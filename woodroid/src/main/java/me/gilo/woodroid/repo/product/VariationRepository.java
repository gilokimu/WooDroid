package me.gilo.woodroid.repo.product;

import me.gilo.woodroid.data.api.ProductCategoryAPI;
import me.gilo.woodroid.data.api.ProductVariationAPI;
import me.gilo.woodroid.models.Category;
import me.gilo.woodroid.models.Product;
import me.gilo.woodroid.models.Variation;
import me.gilo.woodroid.repo.WooRepository;
import retrofit2.Call;

import java.util.List;

public class VariationRepository extends WooRepository {

    private final ProductVariationAPI apiService;
    Product product;

    public VariationRepository(String baseUrl, String consumerKey, String consumerSecret, Product product) {
       super("products/categories", baseUrl, consumerKey, consumerSecret);
       apiService = retrofit.create(ProductVariationAPI.class);

       this.product = product;
    }

    public Call<Variation> create(Variation variation) {
        return apiService.create(product.getId(), variation);
    }


    public Call<Variation> variation(int id) {
        return apiService.view(product.getId(), id);
    }

    public Call<List<Variation>> variations() {
        return apiService.list(product.getId());
    }

    public Call<Variation> update(int id, Variation variation) {
        return apiService.update(product.getId(), id, variation);
    }

    public Call<Variation> delete(int id) {
        return apiService.delete(product.getId(), id);
    }

    public Call<Variation> delete(int id, boolean force) {
        return apiService.delete(product.getId(), id, force);
    }


}

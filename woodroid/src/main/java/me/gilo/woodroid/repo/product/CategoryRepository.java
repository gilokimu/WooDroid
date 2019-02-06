package me.gilo.woodroid.repo.product;

import me.gilo.woodroid.data.api.CustomerAPI;
import me.gilo.woodroid.data.api.ProductCategoryAPI;
import me.gilo.woodroid.models.Category;
import me.gilo.woodroid.models.Customer;
import me.gilo.woodroid.repo.WooRepository;
import retrofit2.Call;

import java.util.List;

public class CategoryRepository extends WooRepository {

    private final ProductCategoryAPI apiService;

    public CategoryRepository(String baseUrl, String consumerKey, String consumerSecret) {
       super("products/categories", baseUrl, consumerKey, consumerSecret);
       apiService = retrofit.create(ProductCategoryAPI.class);
    }

    public Call<Category> create(Category category) {
        return apiService.create(category);
    }


    public Call<Category> category(int id) {
        return apiService.view(id);
    }

    public Call<List<Category>> categories() {
        return apiService.list();
    }

    public Call<Category> update(int id, Category category) {
        return apiService.update(id, category);
    }

    public Call<Category> delete(int id) {
        return apiService.delete(id);
    }

    public Call<Category> delete(int id, boolean force) {
        return apiService.delete(id, force);
    }


}

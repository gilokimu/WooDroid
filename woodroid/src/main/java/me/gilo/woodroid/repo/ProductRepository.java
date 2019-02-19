package me.gilo.woodroid.repo;

import me.gilo.woodroid.data.api.ProductAPI;
import me.gilo.woodroid.models.Product;
import retrofit2.Call;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository extends WooRepository {

    private final ProductAPI apiService;

    public ProductRepository(String baseUrl, String consumerKey, String consumerSecret) {
        super(baseUrl, consumerKey, consumerSecret);
        apiService = retrofit.create(ProductAPI.class);
    }

    public Call<Product> create(Product product) {
        return apiService.create(product);
    }


    public Call<Product> product(int id) {
        return apiService.view(id);
    }

    public Call<List<Product>> products() {
        return apiService.list();
    }

    public Call<List<Product>> filter(Map<String, String> filters) {
        return apiService.filter(filters);
    }

    public Call<Product> update(int id, Product product) {
        return apiService.update(id, product);
    }

    public Call<Product> delete(int id) {
        return apiService.delete(id);
    }

    public Call<Product> delete(int id, boolean force) {
        return apiService.delete(id, force);
    }

    public Call<List<Product>> products(HashMap<String, String> filters) {
        return apiService.filter(filters);
    }


}

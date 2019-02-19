package me.gilo.woodroid.repo;

import me.gilo.woodroid.data.api.ProductAPI;
import me.gilo.woodroid.models.Product;
import me.gilo.woodroid.models.filters.ProductFilter;
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

    public Call<List<Product>> products(ProductFilter productFilter) {
        return filter(productFilter.getFilters());
    }

    public Call<List<Product>> search(String term) {
        ProductFilter productFilter = new ProductFilter();
        productFilter.setSearch(term);

        return filter(productFilter.getFilters());
    }

    public Call<List<Product>> products(int page, int per_page) {
        ProductFilter productFilter = new ProductFilter();
        productFilter.setPage(page);
        productFilter.setPer_page(per_page);

        return filter(productFilter.getFilters());
    }

    public Call<List<Product>> products(int page) {
        ProductFilter productFilter = new ProductFilter();
        productFilter.setPage(page);

        return filter(productFilter.getFilters());
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

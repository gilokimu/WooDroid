package me.gilo.woodroid.repo;

import me.gilo.woodroid.data.api.API;
import me.gilo.woodroid.data.api.ProductAPI;
import me.gilo.woodroid.data.api.ProductCategoryAPI;
import me.gilo.woodroid.models.Product;
import me.gilo.woodroid.repo.WooRepository;
import retrofit2.Call;

import java.util.ArrayList;
import java.util.HashMap;

public class ProductRepository extends WooRepository {

    private final ProductAPI apiService;

    public ProductRepository(String baseUrl, String consumerKey, String consumerSecret) {
        super("products", baseUrl, consumerKey, consumerSecret);
        apiService = retrofit.create(ProductAPI.class);
    }

    //TODO
    public void create(Product product) {

    }

    //TODO
    public void update() {

    }

    //TODO
    public void delete() {

    }

    public Call<ArrayList<Product>> products() {
        API apiService = restAdapter.createAPI("products");
        return apiService.getProducts();

    }

    public Call<ArrayList<Product>> products(HashMap<String, String> filters) {
        API apiService = restAdapter.createAPI("products", filters);
        return apiService.filter(filters);
    }






}

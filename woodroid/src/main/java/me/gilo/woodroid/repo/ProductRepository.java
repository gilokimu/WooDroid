package me.gilo.woodroid.repo;

import me.gilo.woodroid.data.API;
import me.gilo.woodroid.data.RestAdapter;
import me.gilo.woodroid.models.Category;
import me.gilo.woodroid.models.Product;
import retrofit2.Call;

import java.util.ArrayList;
import java.util.HashMap;

public class ProductRepository {

    private String baseUrl;
    private String consumerKey;
    private String consumerSecret;

    RestAdapter restAdapter;

    public ProductRepository(String baseUrl, String consumerKey, String consumerSecret) {
        this.baseUrl = baseUrl;
        this.consumerKey = consumerKey;
        this.consumerSecret = consumerSecret;

        restAdapter = new RestAdapter(baseUrl, consumerKey, consumerSecret);
    }

    public Call<ArrayList<Product>> products() {
        API apiService = restAdapter.createAPI("products");
        return apiService.getProducts();

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

    public Call<ArrayList<Product>> products(HashMap<String, String> filters) {
        API apiService = restAdapter.createAPI("products", filters);
        return apiService.filter(filters);
    }

    public Call<ArrayList<Category>> categories() {
        API apiService = restAdapter.createAPI("products/categories");
        return  apiService.getCategories();
    }

    public Call<ArrayList<Category>> categories(HashMap<String, String> filters) {
        API apiService = restAdapter.createAPI("products/categories", filters);
        return apiService.getCategories();
    }

    public Call<ArrayList<Category>> categories(int parent_category) {
        API apiService = restAdapter.createAPI("products/categories");
        return apiService.getCategories();
    }




}

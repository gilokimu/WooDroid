package me.gilo.woodroid.repo;

import me.gilo.woodroid.data.API;
import me.gilo.woodroid.data.RestAdapter;
import me.gilo.woodroid.models.Category;
import me.gilo.woodroid.models.Product;
import retrofit2.Call;

import java.util.ArrayList;
import java.util.HashMap;

public class ProductRepository extends WooRepository{


    public ProductRepository(String baseUrl, String consumerKey, String consumerSecret) {
        super(baseUrl, consumerKey, consumerSecret);
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

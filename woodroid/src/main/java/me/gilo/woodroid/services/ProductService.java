package me.gilo.woodroid.services;

import me.gilo.woodroid.models.Product;
import me.gilo.woodroid.repo.ProductRepository;
import retrofit2.Call;

import java.util.List;

public class ProductService {

    final ProductRepository productRepository;

    public ProductService(String baseUrl, String consumerKey, String consumerSecret) {
        productRepository = new ProductRepository(baseUrl, consumerKey, consumerSecret);
    }

    public Call<Product> create(Product product) {
        return productRepository.create(product);
    }


    public Call<Product> product(int id) {
        return productRepository.product(id);
    }

    public Call<List<Product>> products() {
        return productRepository.products();
    }

    public Call<Product> update(int id, Product product) {
        return productRepository.update(id, product);
    }

    public Call<Product> delete(int id) {
        return productRepository.delete(id);
    }

    public Call<Product> delete(int id, boolean force) {
        return productRepository.delete(id, force);
    }

}

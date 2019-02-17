package me.gilo.woodroid.data.callbacks;


import me.gilo.woodroid.models.Product;

import java.util.ArrayList;


public class ProductCallback {
    ArrayList<Product> products = new ArrayList<>();
    Product product;

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

package me.gilo.wc.events;

import me.gilo.woodroid.models.Product;

public class ProductEvent {

    Product product;

    public ProductEvent(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

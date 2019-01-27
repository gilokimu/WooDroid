package me.gilo.woodroid.models;

import java.util.ArrayList;

/**
 * Created by gilo on 2/18/16.
 */
public class CartItem {
    Product product;
    ArrayList<Option> options;
    int qty;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ArrayList<Option> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<Option> options) {
        this.options = options;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}

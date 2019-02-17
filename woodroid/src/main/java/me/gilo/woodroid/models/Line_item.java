package me.gilo.woodroid.models;

public class Line_item {
    private int product_id;
    private int quantity;
    private String variations;

    public Line_item(int product_id, int quantity, String variations) {
        this.product_id = product_id;
        this.quantity = quantity;
        this.variations = variations;
    }

    public Line_item(int product_id, int quantity) {
        this.product_id = product_id;
        this.quantity = quantity;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getVariations() {
        return variations;
    }

    public void setVariations(String variations) {
        this.variations = variations;
    }
}

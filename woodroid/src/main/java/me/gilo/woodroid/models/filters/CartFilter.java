package me.gilo.woodroid.models.filters;

public class CartFilter {

    String cart_item_key;
    int quantity;

    public CartFilter(String cart_item_key) {
        this.cart_item_key = cart_item_key;
    }

    public String getCart_item_key() {
        return cart_item_key;
    }

    public void setCart_item_key(String cart_item_key) {
        this.cart_item_key = cart_item_key;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

package me.gilo.woodroid.data.callbacks;


import me.gilo.woodroid.models.Order;

import java.util.ArrayList;

/**
 * Created by Aron on 12/7/2015.
 */
public class OrderCallback {
    ArrayList<Order> orders = new ArrayList<>();

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
}

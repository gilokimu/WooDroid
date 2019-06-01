package me.gilo.woodroid.app.events;

import me.gilo.woodroid.app.models.CartLineItem;

public class AddQuantityEvent {

    CartLineItem cartLineItem;

    public AddQuantityEvent(CartLineItem cartLineItem) {
        this.cartLineItem = cartLineItem;
    }

    public CartLineItem getCartLineItem() {
        return cartLineItem;
    }

    public void setCartLineItem(CartLineItem cartLineItem) {
        this.cartLineItem = cartLineItem;
    }
}

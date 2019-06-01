package me.gilo.woodroid.app.events;

import me.gilo.woodroid.app.models.CartLineItem;

public class LessQuantityEvent {

    CartLineItem cartLineItem;

    public LessQuantityEvent(CartLineItem cartLineItem) {
        this.cartLineItem = cartLineItem;
    }

    public CartLineItem getCartLineItem() {
        return cartLineItem;
    }

    public void setCartLineItem(CartLineItem cartLineItem) {
        this.cartLineItem = cartLineItem;
    }
}

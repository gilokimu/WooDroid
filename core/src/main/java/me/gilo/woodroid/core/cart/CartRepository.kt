package me.gilo.woodroid.core.cart

import android.arch.lifecycle.LiveData
import me.gilo.woodroid.models.LineItem


abstract class CartRepository{

    abstract fun clear(): LiveData<String>
    abstract fun count(id: Int): LiveData<Int>
    abstract fun cart(): LiveData<List<LineItem>>
    abstract fun addToCart(lineItem: LineItem): LiveData<LineItem>
    abstract fun delete(cartId: String): LiveData<String>
    abstract fun restore(cartId: String): LiveData<String>
    abstract fun update(cartId: String, quantity: Int): LiveData<LineItem>

}

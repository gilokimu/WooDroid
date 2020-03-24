package me.gilo.woodroid.offlinecart.task

import android.os.AsyncTask
import androidx.lifecycle.MutableLiveData
import me.gilo.woodroid.core.cart.Cart
import me.gilo.woodroid.core.cart.CartItem
import me.gilo.woodroid.offlinecart.db.AppDatabase
import me.gilo.woodroid.offlinecart.entity.toCartItem
import me.gilo.woodroid.offlinecart.entity.toCartItemEntity
import java.util.*
import kotlin.collections.ArrayList


class InsertCartItem(
    private val appDatabase: AppDatabase,
    private val cartItem: CartItem
) :
    AsyncTask<Void, Void, Long?>() {

    override fun doInBackground(vararg voids: Void): Long? {

        return appDatabase.cartItemDao()
            .insert(cartItem.toCartItemEntity())
    }
}

class UpdateCartItem(
    private val appDatabase: AppDatabase,
    private val cartItem: CartItem
) :
    AsyncTask<Void, Void, Unit>() {

    override fun doInBackground(vararg voids: Void) {
        return appDatabase.cartItemDao().update(cartItem.toCartItemEntity())
    }
}

class DeleteCartItem(
    private val appDatabase: AppDatabase,
    private val cartItem: CartItem
) :
    AsyncTask<Void, Void, Unit>() {

    override fun doInBackground(vararg voids: Void) {
        return appDatabase.cartItemDao().delete(cartItem.toCartItemEntity())
    }
}

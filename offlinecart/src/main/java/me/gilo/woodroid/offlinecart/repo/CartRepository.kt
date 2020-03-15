package me.gilo.woodroid.offlinecart.repo

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.room.Room
import me.gilo.moneta.room.task.DeleteCartItem
import me.gilo.moneta.room.task.InsertCartItem
import me.gilo.moneta.room.task.RetrieveCartItems
import me.gilo.moneta.room.task.UpdateCartItem
import me.gilo.woodroid.offlinecart.utils.AppUtils
import me.gilo.woodroid.core.cart.CartItem
import me.gilo.woodroid.offlinecart.config.Config
import me.gilo.woodroid.offlinecart.db.AppDatabase
import me.gilo.woodroid.offlinecart.entity.CartItemEntity
import me.gilo.woodroid.offlinecart.entity.toCartItem

class RoomCartRepository(val context: Context){

    private val appDatabase: AppDatabase = Room
        .databaseBuilder(context, AppDatabase::class.java, Config.DB_NAME)
        .fallbackToDestructiveMigration()
        .build()


    fun addToCart(cartItem: CartItem) {
        if (cartItem.createdAt == null) {
            cartItem.createdAt = AppUtils.currentDateTime.time
        }

        InsertCartItem(appDatabase, cartItem).execute()
    }

    fun update(cartItem: CartItem) {
        cartItem.modifiedAt = AppUtils.currentDateTime.time
        UpdateCartItem(appDatabase, cartItem).execute()

    }

    fun count(): LiveData<Int> {
        return appDatabase.cartItemDao().count()
    }

    fun delete(cartItem: CartItem) {
        DeleteCartItem(appDatabase, cartItem).execute()
    }

    fun cartItem(id: Int): LiveData<CartItem> {
        return Transformations.map(
            appDatabase.cartItemDao().get(id)
        ) { cartItemEntity: CartItemEntity? -> cartItemEntity?.toCartItem()
        }
    }

    fun items(): LiveData<List<CartItem>> {
        val data: MutableLiveData<List<CartItem>> = MutableLiveData()
        RetrieveCartItems(appDatabase, data).execute()

        return data
    }

}

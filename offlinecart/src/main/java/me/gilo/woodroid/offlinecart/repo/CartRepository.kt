package me.gilo.woodroid.offlinecart.repo

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.room.Room
import me.gilo.woodroid.offlinecart.task.DeleteCartItem
import me.gilo.woodroid.offlinecart.task.InsertCartItem
import me.gilo.woodroid.offlinecart.task.UpdateCartItem
import me.gilo.woodroid.core.cart.Cart
import me.gilo.woodroid.core.cart.CartItem
import me.gilo.woodroid.offlinecart.config.Config
import me.gilo.woodroid.offlinecart.db.AppDatabase
import me.gilo.woodroid.offlinecart.entity.CartItemEntity
import me.gilo.woodroid.offlinecart.entity.toCartItem
import me.gilo.woodroid.offlinecart.utils.AppUtils

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

    fun exists(productId: Int): LiveData<Boolean> {
        return appDatabase.cartItemDao().exists(productId)
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

    fun cart(): Cart {
        return Cart(
            items = Transformations.map(appDatabase.cartItemDao().items()){
                it.map { cartItemEntity -> cartItemEntity.toCartItem() }
            }
        )
    }

}

package me.gilo.woodroid.offlinecart.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import me.gilo.woodroid.offlinecart.entity.CartItemEntity

@Dao
interface CartItemDao {
    @Insert
    fun insert(category: CartItemEntity?): Long?

    @Query("SELECT * FROM cart_item ORDER BY created_at desc")
    fun fetchAll(): List<CartItemEntity>

    @Query("SELECT * FROM cart_item ORDER BY created_at desc")
    fun items(): LiveData<List<CartItemEntity>>

    @Query("SELECT COUNT(*) FROM cart_item")
    fun count(): LiveData<Int>

    @Query("SELECT COUNT(*) FROM cart_item where product_id = :productId")
    fun exists(productId: Int): LiveData<Boolean>

    @Query("SELECT * FROM cart_item WHERE id =:id")
    operator fun get(id: Int): LiveData<CartItemEntity>

    @Update
    fun update(category: CartItemEntity?)

    @Delete
    fun delete(category: CartItemEntity?)
}
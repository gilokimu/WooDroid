package me.gilo.woodroid.offlinecart.db

import androidx.room.Database
import androidx.room.RoomDatabase
import me.gilo.woodroid.offlinecart.dao.CartItemDao
import me.gilo.woodroid.offlinecart.entity.CartItemEntity

@Database(
    entities = [
        CartItemEntity::class
    ], version = 1, exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cartItemDao(): CartItemDao
}
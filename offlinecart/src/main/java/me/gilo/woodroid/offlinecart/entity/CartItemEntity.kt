package me.gilo.woodroid.offlinecart.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import me.gilo.woodroid.core.cart.CartItem

@Entity(tableName = "cart_item")
data class CartItemEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Int? = 0,

    @ColumnInfo(name = "created_at")
    var createdAt: Long? = null,

    @ColumnInfo(name = "modified_at")
    var modifiedAt: Long? = null,

    @ColumnInfo(name = "product_id")
    var productId: Int = 0,

    @ColumnInfo(name = "quantity")
    var quantity: Int = 0,

    @ColumnInfo(name = "variation_id")
    var variationId: Int? = 0,

    @ColumnInfo(name = "product_name")
    var productName: String? = "",

    @ColumnInfo(name = "product_price")
    var productPrice: String? = "",

    @ColumnInfo(name = "product_image")
    var productImage: String? = ""
)

fun CartItemEntity.toCartItem() = CartItem(
    id = this.id,
    createdAt = this.createdAt,
    modifiedAt = this.modifiedAt,
    productId = this.productId,
    quantity = this.quantity,
    variationId = this.variationId,
    productName = this.productName,
    productPrice = this.productPrice,
    productImage = this.productImage
)

fun CartItem.toCartItemEntity() = CartItemEntity(
    id = this.id,
    createdAt = this.createdAt,
    modifiedAt = this.modifiedAt,
    productId = this.productId,
    quantity = this.quantity,
    variationId = this.variationId,
    productName = this.productName,
    productPrice = this.productPrice,
    productImage = this.productImage
)

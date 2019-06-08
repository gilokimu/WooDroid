package me.gilo.woodroid.models

import java.util.ArrayList

/**
 * Created by gilo on 2/18/16.
 */
class CartItem {
    lateinit var product: Product
    lateinit var options: ArrayList<Option>
    var qty: Int = 0
}

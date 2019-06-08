package me.gilo.woodroid.data.callbacks


import com.google.gson.annotations.SerializedName
import me.gilo.woodroid.models.Category


import java.util.ArrayList


class CategoriesCallback {
    @SerializedName("product_categories")
    lateinit var categories: ArrayList<Category>
}

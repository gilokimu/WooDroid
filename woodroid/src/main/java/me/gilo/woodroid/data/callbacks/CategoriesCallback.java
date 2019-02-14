package me.gilo.woodroid.data.callbacks;


import com.google.gson.annotations.SerializedName;
import me.gilo.woodroid.models.Category;


import java.util.ArrayList;


public class CategoriesCallback {
    @SerializedName("product_categories")
    ArrayList<Category> categories;

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }
}

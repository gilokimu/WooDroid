package me.gilo.woodroid.app.repo


import me.gilo.woodroid.app.common.WooLiveData
import me.gilo.woodroid.Woocommerce
import me.gilo.woodroid.models.Category
import me.gilo.woodroid.models.filters.ProductCategoryFilter

import javax.inject.Inject

class CategoryRepository @Inject
constructor() {

    @Inject
    lateinit var woocommerce: Woocommerce


    fun create(category: Category): WooLiveData<Category> {
        val callBack = WooLiveData<Category>()

        woocommerce.CategoryRepository().create(category).enqueue(callBack)
        return callBack
    }


    fun category(id: Int): WooLiveData<Category> {
        val callBack = WooLiveData<Category>()

        woocommerce.CategoryRepository().category(id).enqueue(callBack)
        return callBack
    }

    fun categories(): WooLiveData<List<Category>> {
        val callBack = WooLiveData<List<Category>>()

        woocommerce.CategoryRepository().categories().enqueue(callBack)
        return callBack
    }

    fun categories(productCategoryFilter: ProductCategoryFilter): WooLiveData<List<Category>> {
        val callBack = WooLiveData<List<Category>>()

        woocommerce.CategoryRepository().categories(productCategoryFilter).enqueue(callBack)
        return callBack
    }

    fun update(id: Int, category: Category): WooLiveData<Category> {
        val callBack = WooLiveData<Category>()

        woocommerce.CategoryRepository().update(id, category).enqueue(callBack)
        return callBack
    }

    fun delete(id: Int): WooLiveData<Category> {
        val callBack = WooLiveData<Category>()

        woocommerce.CategoryRepository().delete(id).enqueue(callBack)
        return callBack
    }

    fun delete(id: Int, force: Boolean): WooLiveData<Category> {
        val callBack = WooLiveData<Category>()

        woocommerce.CategoryRepository().delete(id, force).enqueue(callBack)
        return callBack
    }


}

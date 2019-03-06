package me.gilo.wc.repo;


import me.gilo.wc.common.WooLiveData;
import me.gilo.woodroid.Woocommerce;
import me.gilo.woodroid.models.Category;
import me.gilo.woodroid.models.filters.ProductCategoryFilter;

import javax.inject.Inject;
import java.util.List;

public class CategoryRepository {

    @Inject
    Woocommerce woocommerce;

    @Inject
    public CategoryRepository() {
    }


    public WooLiveData<Category> create(Category category) {
        final WooLiveData<Category> callBack = new WooLiveData();

        woocommerce.CategoryRepository().create(category).enqueue(callBack);
        return callBack;
    }


    public WooLiveData<Category> category(int id) {
        final WooLiveData<Category> callBack = new WooLiveData();

        woocommerce.CategoryRepository().category(id).enqueue(callBack);
        return callBack;
    }

    public WooLiveData<List<Category>> categories() {
        final WooLiveData<List<Category>> callBack = new WooLiveData();

        woocommerce.CategoryRepository().categories().enqueue(callBack);
        return callBack;
    }

    public WooLiveData<List<Category>> categories(ProductCategoryFilter productCategoryFilter) {
        final WooLiveData<List<Category>> callBack = new WooLiveData();

        woocommerce.CategoryRepository().categories(productCategoryFilter).enqueue(callBack);
        return callBack;
    }

    public WooLiveData<Category> update(int id, Category category) {
        final WooLiveData<Category> callBack = new WooLiveData();

        woocommerce.CategoryRepository().update(id, category).enqueue(callBack);
        return callBack;
    }

    public WooLiveData<Category> delete(int id) {
        final WooLiveData<Category> callBack = new WooLiveData();

        woocommerce.CategoryRepository().delete(id).enqueue(callBack);
        return callBack;
    }

    public WooLiveData<Category> delete(int id, boolean force) {
        final WooLiveData<Category> callBack = new WooLiveData();

        woocommerce.CategoryRepository().delete(id, force).enqueue(callBack);
        return callBack;
    }


}

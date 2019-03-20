package me.gilo.wc.repo;


import me.gilo.wc.common.WooLiveData;
import me.gilo.woodroid.Woocommerce;
import me.gilo.woodroid.models.Product;
import me.gilo.woodroid.models.ProductReview;
import me.gilo.woodroid.models.filters.ProductFilter;
import me.gilo.woodroid.models.filters.ProductReviewFilter;

import javax.inject.Inject;
import java.util.List;

public class ProductRepository {

    @Inject
    Woocommerce woocommerce;

    @Inject
    public ProductRepository() {
    }

    public WooLiveData<List<Product>> products() {
        final WooLiveData<List<Product>> callBack = new WooLiveData();

        woocommerce.ProductRepository().products().enqueue(callBack);
        return callBack;
    }

    public WooLiveData<List<Product>> products(ProductFilter productFilter) {
        final WooLiveData<List<Product>> callBack = new WooLiveData();

        woocommerce.ProductRepository().products(productFilter).enqueue(callBack);
        return callBack;
    }


    public WooLiveData<Product> product(int productId) {
        final WooLiveData<Product> callBack = new WooLiveData();

        woocommerce.ProductRepository().product(productId).enqueue(callBack);
        return callBack;
    }


    public WooLiveData<List<ProductReview>> reviews(int productId) {
        final WooLiveData<List<ProductReview>> callBack = new WooLiveData();

        ProductReviewFilter filter = new ProductReviewFilter();
        int[] products = {productId};

        filter.setProduct(products);

        woocommerce.ReviewRepository().reviews(filter).enqueue(callBack);
        return callBack;
    }


    public WooLiveData<List<Product>> search(String term) {
        final WooLiveData<List<Product>> callBack = new WooLiveData();

        woocommerce.ProductRepository().search(term).enqueue(callBack);
        return callBack;
    }


}

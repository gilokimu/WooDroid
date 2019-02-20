package me.gilo.wc.viewmodels;

import android.arch.lifecycle.ViewModel;
import me.gilo.wc.common.WooLiveData;
import me.gilo.wc.repo.ProductRepository;
import me.gilo.woodroid.models.Product;

import javax.inject.Inject;
import java.util.List;


public final class ProductViewModel extends ViewModel {
    private final ProductRepository productRepository;

    @Inject
    ProductViewModel(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public WooLiveData<List<Product>> products() {
        return productRepository.products();
    }

    public WooLiveData<List<Product>> search(String term) {
        return productRepository.search(term);
    }
}
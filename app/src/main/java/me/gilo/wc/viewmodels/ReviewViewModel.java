package me.gilo.wc.viewmodels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import me.gilo.wc.common.WooLiveData;
import me.gilo.wc.repo.CartRepository;
import me.gilo.wc.repo.OrderRepository;
import me.gilo.wc.repo.ProductRepository;
import me.gilo.wc.repo.ReviewRepository;
import me.gilo.woodroid.models.LineItem;
import me.gilo.woodroid.models.Product;
import me.gilo.woodroid.models.ProductReview;
import me.gilo.woodroid.models.filters.ProductFilter;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;


public final class ReviewViewModel extends ViewModel {
    private final ReviewRepository reviewRepository;

    @Inject
    ReviewViewModel(ReviewRepository reviewRepository) {
        this.reviewRepository =  reviewRepository;
    }

    public WooLiveData<List<ProductReview>> reviews(int productId) {
        return reviewRepository.reviews(productId);
    }

    public WooLiveData<ProductReview> create(ProductReview review) {
        return reviewRepository.create(review);
    }

}
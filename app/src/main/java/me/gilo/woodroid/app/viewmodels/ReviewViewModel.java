package me.gilo.woodroid.app.viewmodels;

import android.arch.lifecycle.ViewModel;
import me.gilo.woodroid.app.common.WooLiveData;
import me.gilo.woodroid.app.repo.ReviewRepository;
import me.gilo.woodroid.models.ProductReview;

import javax.inject.Inject;
import java.util.List;


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
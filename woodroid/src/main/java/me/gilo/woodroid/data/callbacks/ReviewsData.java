package me.gilo.woodroid.data.callbacks;


import me.gilo.woodroid.models.ProductReview;

import java.util.ArrayList;


public class ReviewsData {
    ArrayList<ProductReview> productReviews;

    public ArrayList<ProductReview> getProductReviews() {
        return productReviews;
    }

    public void setProductReviews(ArrayList<ProductReview> productReviews) {
        this.productReviews = productReviews;
    }
}

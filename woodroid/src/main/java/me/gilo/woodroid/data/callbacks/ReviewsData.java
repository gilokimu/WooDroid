package me.gilo.woodroid.data.callbacks;


import me.gilo.woodroid.models.ProductReview;

import java.util.ArrayList;

/**
 * Created by Aron on 12/14/2015.
 */
public class ReviewsData {
    ArrayList<ProductReview> productReviews;

    public ArrayList<ProductReview> getProductReviews() {
        return productReviews;
    }

    public void setProductReviews(ArrayList<ProductReview> productReviews) {
        this.productReviews = productReviews;
    }
}

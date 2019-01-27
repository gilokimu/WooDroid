package me.gilo.woodroid.data.callbacks;


import com.google.gson.annotations.SerializedName;
import me.gilo.woodroid.models.ProductReview;

import java.util.ArrayList;


/**
 * Created by Aron on 12/8/2015.
 */
public class ReviewsCallback {
    @SerializedName("product_reviews")
    ArrayList<ProductReview> productReviews;

    public ArrayList<ProductReview> getProductReviews() {
        return productReviews;
    }

    public void setProductReviews(ArrayList<ProductReview> productReviews) {
        this.productReviews = productReviews;
    }
}

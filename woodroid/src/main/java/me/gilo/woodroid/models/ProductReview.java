package me.gilo.woodroid.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;


public class ProductReview implements Serializable{
    private int id;
    private Date date_created;
    private Date date_created_gmt;
    int product_id;
    String reviewer;
    String reviewer_email;

    Map<String, String> reviewer_avatar_urls;

    private String review;
    private int rating;
    private boolean verified;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public Date getDate_created_gmt() {
        return date_created_gmt;
    }

    public void setDate_created_gmt(Date date_created_gmt) {
        this.date_created_gmt = date_created_gmt;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getReviewer_email() {
        return reviewer_email;
    }

    public void setReviewer_email(String reviewer_email) {
        this.reviewer_email = reviewer_email;
    }

    public Map<String, String> getReviewer_avatar_urls() {
        return reviewer_avatar_urls;
    }

    public void setReviewer_avatar_urls(Map<String, String> reviewer_avatar_urls) {
        this.reviewer_avatar_urls = reviewer_avatar_urls;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }
}

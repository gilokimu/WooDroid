package me.gilo.woodroid.models;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Aron on 12/9/2015.
 */
public class ProductReview implements Serializable{
    private int id;
    private Date date_created;
    private Date date_created_gmt;
    private String review;
    private int rating;
    private String name;
    private String email;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }
}

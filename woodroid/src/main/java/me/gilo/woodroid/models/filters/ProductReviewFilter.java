package me.gilo.woodroid.models.filters;

public class ProductReviewFilter extends ListFilter{

    int[] reviewer;
    int[] reviewer_exclude;
    String[] reviewer_email;

    int[] product;
    String status;

    public int[] getReviewer() {
        return reviewer;
    }

    public void setReviewer(int[] reviewer) {
        this.reviewer = reviewer;

        addFilter("reviewer", reviewer);
    }

    public int[] getReviewer_exclude() {
        return reviewer_exclude;
    }

    public void setReviewer_exclude(int[] reviewer_exclude) {
        this.reviewer_exclude = reviewer_exclude;

        addFilter("reviewer_exclude", reviewer_exclude);
    }

    public String[] getReviewer_email() {
        return reviewer_email;
    }

    public void setReviewer_email(String[] reviewer_email) {
        this.reviewer_email = reviewer_email;

        addFilter("reviewer_email", reviewer_email);
    }

    public int[] getProduct() {
        return product;
    }

    public void setProduct(int[] product) {
        this.product = product;

        addFilter("product", product);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;

        addFilter("status", status);
    }
}

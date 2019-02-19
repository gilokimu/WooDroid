package me.gilo.woodroid.models.filters;

public class ProductTagFilter extends ListFilter{

    int product;
    boolean hide_empty;
    String slug;


    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
        addFilter("product", product);
    }

    public boolean isHide_empty() {
        return hide_empty;
    }

    public void setHide_empty(boolean hide_empty) {
        this.hide_empty = hide_empty;
        addFilter("hide_empty", hide_empty);
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
        addFilter("slug", slug);
    }
}

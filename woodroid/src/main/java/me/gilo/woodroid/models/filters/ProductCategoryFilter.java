package me.gilo.woodroid.models.filters;

public class ProductCategoryFilter extends ListFilter{
    private int[] parent;
    int product;
    boolean hide_empty;
    String slug;

    public int[] getParent() {
        return parent;
    }

    public void setParent(int[] parent) {
        this.parent = parent;
        addFilter("parent", parent);
    }

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

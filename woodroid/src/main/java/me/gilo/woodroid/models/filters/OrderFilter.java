package me.gilo.woodroid.models.filters;

public class OrderFilter extends ListFilter{

    private int[] parent;
    private int[] parent_exclude;

    String status;

    int customer;
    int product;
    int dp;

    public int[] getParent() {
        return parent;
    }

    public void setParent(int[] parent) {
        this.parent = parent;
        addFilter("parent", parent);
    }

    public int[] getParent_exclude() {
        return parent_exclude;
    }

    public void setParent_exclude(int[] parent_exclude) {
        this.parent_exclude = parent_exclude;

        addFilter("parent_exclude", parent_exclude);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;

        addFilter("status", status);
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;

        addFilter("customer", customer);
    }

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;

        addFilter("product", product);
    }

    public int getDp() {
        return dp;
    }

    public void setDp(int dp) {
        this.dp = dp;
        addFilter("dp", dp);

    }
}

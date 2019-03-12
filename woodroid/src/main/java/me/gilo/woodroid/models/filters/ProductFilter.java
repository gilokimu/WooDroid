package me.gilo.woodroid.models.filters;

public class ProductFilter extends ListFilter{
    private int[] parent;
    private int[] parent_exclude;
    private String slug;
    private String status;
    private String type;
    private String sku;
    private boolean featured;
    private int category;
    private String tag;
    private String shipping_class;
    private String attribute;
    private String attribute_term;
    private String tax_class;
    private boolean on_sale;
    private String min_price;
    private String max_price;
    private String stock_status;

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

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;

        addFilter("slug", slug);

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;

        addFilter("status", status);

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;

        addFilter("type", type);
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;

        addFilter("sku", sku);
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;

        addFilter("featured", featured);
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;

        addFilter("category", category);
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;

        addFilter("tag", tag);
    }

    public String getShipping_class() {
        return shipping_class;
    }

    public void setShipping_class(String shipping_class) {
        this.shipping_class = shipping_class;

        addFilter("shipping_class", shipping_class);
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;

        addFilter("attribute", attribute);
    }

    public String getAttribute_term() {
        return attribute_term;
    }

    public void setAttribute_term(String attribute_term) {
        this.attribute_term = attribute_term;

        addFilter("attribute_term", attribute_term);
    }


    public String getTax_class() {
        return tax_class;
    }

    public void setTax_class(String tax_class) {
        this.tax_class = tax_class;

        addFilter("tax_class", tax_class);
    }

    public boolean isOn_sale() {
        return on_sale;
    }

    public void setOn_sale(boolean on_sale) {
        this.on_sale = on_sale;

        addFilter("on_sale", on_sale);
    }

    public String getMin_price() {
        return min_price;
    }

    public void setMin_price(String min_price) {
        this.min_price = min_price;

        addFilter("min_price", min_price);
    }

    public String getMax_price() {
        return max_price;
    }

    public void setMax_price(String max_price) {
        this.max_price = max_price;

        addFilter("max_price", max_price);
    }

    public String getStock_status() {
        return stock_status;
    }

    public void setStock_status(String stock_status) {
        this.stock_status = stock_status;

        addFilter("stock_status", stock_status);
    }
}

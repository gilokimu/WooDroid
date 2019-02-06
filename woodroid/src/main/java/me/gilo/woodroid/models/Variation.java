package me.gilo.woodroid.models;

import java.util.ArrayList;
import java.util.Date;

public class Variation {

    int id;
    String title;
    String name;
    String slug;
    String permalink;
    String type;
    String status;
    boolean featured;
    String catalog_visibility;
    String description;
    String short_description;
    String sku;
    String price;
    String regular_price;
    String sale_price;
    Date date_on_sale_from;
    Date date_on_sale_from_gmt;
    Date date_on_sale_to;
    Date date_on_sale_to_gmt;
    String price_html;
    boolean on_sale;
    boolean purchasable;
    int total_sales;
    boolean virtual;
    boolean downloadable;
    ArrayList<Download> downloads;
    int download_limit;
    int download_expiry;
    String external_url;
    String button_text;
    String tax_status;
    String tax_class;
    boolean manage_stock;
    int stock_quantity;
    boolean in_stock;
    String backorders;
    boolean backorders_allowed;
    boolean backordered;
    boolean sold_individually;
    String weight;
    Object dimensions;
    boolean shipping_required;
    boolean shipping_taxable;
    String shipping_class;
    int shipping_class_id;
    boolean reviews_allowed;
    String average_rating;
    int rating_count;
    ArrayList<Integer> related_ids;
    ArrayList<Integer> upsell_ids;
    ArrayList<Integer> cross_sell_ids;
    int parent_id;
    String purchase_note;
    ArrayList<Category> categories;
    ArrayList<Tag> tags;
    ArrayList<Attribute> attributes;
    ArrayList<DefaultAttribute> default_attributes;
    ArrayList<Integer> grouped_products;
    int menu_order;
    ArrayList<Metadata> meta_data;
    ArrayList<Image> images;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public String getCatalog_visibility() {
        return catalog_visibility;
    }

    public void setCatalog_visibility(String catalog_visibility) {
        this.catalog_visibility = catalog_visibility;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRegular_price() {
        return regular_price;
    }

    public void setRegular_price(String regular_price) {
        this.regular_price = regular_price;
    }

    public String getSale_price() {
        return sale_price;
    }

    public void setSale_price(String sale_price) {
        this.sale_price = sale_price;
    }

    public Date getDate_on_sale_from() {
        return date_on_sale_from;
    }

    public void setDate_on_sale_from(Date date_on_sale_from) {
        this.date_on_sale_from = date_on_sale_from;
    }

    public Date getDate_on_sale_from_gmt() {
        return date_on_sale_from_gmt;
    }

    public void setDate_on_sale_from_gmt(Date date_on_sale_from_gmt) {
        this.date_on_sale_from_gmt = date_on_sale_from_gmt;
    }

    public Date getDate_on_sale_to() {
        return date_on_sale_to;
    }

    public void setDate_on_sale_to(Date date_on_sale_to) {
        this.date_on_sale_to = date_on_sale_to;
    }

    public Date getDate_on_sale_to_gmt() {
        return date_on_sale_to_gmt;
    }

    public void setDate_on_sale_to_gmt(Date date_on_sale_to_gmt) {
        this.date_on_sale_to_gmt = date_on_sale_to_gmt;
    }

    public String getPrice_html() {
        return price_html;
    }

    public void setPrice_html(String price_html) {
        this.price_html = price_html;
    }

    public boolean isOn_sale() {
        return on_sale;
    }

    public void setOn_sale(boolean on_sale) {
        this.on_sale = on_sale;
    }

    public boolean isPurchasable() {
        return purchasable;
    }

    public void setPurchasable(boolean purchasable) {
        this.purchasable = purchasable;
    }

    public int getTotal_sales() {
        return total_sales;
    }

    public void setTotal_sales(int total_sales) {
        this.total_sales = total_sales;
    }

    public boolean isVirtual() {
        return virtual;
    }

    public void setVirtual(boolean virtual) {
        this.virtual = virtual;
    }

    public boolean isDownloadable() {
        return downloadable;
    }

    public void setDownloadable(boolean downloadable) {
        this.downloadable = downloadable;
    }

    public ArrayList<Download> getDownloads() {
        return downloads;
    }

    public void setDownloads(ArrayList<Download> downloads) {
        this.downloads = downloads;
    }

    public int getDownload_limit() {
        return download_limit;
    }

    public void setDownload_limit(int download_limit) {
        this.download_limit = download_limit;
    }

    public int getDownload_expiry() {
        return download_expiry;
    }

    public void setDownload_expiry(int download_expiry) {
        this.download_expiry = download_expiry;
    }

    public String getExternal_url() {
        return external_url;
    }

    public void setExternal_url(String external_url) {
        this.external_url = external_url;
    }

    public String getButton_text() {
        return button_text;
    }

    public void setButton_text(String button_text) {
        this.button_text = button_text;
    }

    public String getTax_status() {
        return tax_status;
    }

    public void setTax_status(String tax_status) {
        this.tax_status = tax_status;
    }

    public String getTax_class() {
        return tax_class;
    }

    public void setTax_class(String tax_class) {
        this.tax_class = tax_class;
    }

    public boolean isManage_stock() {
        return manage_stock;
    }

    public void setManage_stock(boolean manage_stock) {
        this.manage_stock = manage_stock;
    }

    public int getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(int stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

    public boolean isIn_stock() {
        return in_stock;
    }

    public void setIn_stock(boolean in_stock) {
        this.in_stock = in_stock;
    }

    public String getBackorders() {
        return backorders;
    }

    public void setBackorders(String backorders) {
        this.backorders = backorders;
    }

    public boolean isBackorders_allowed() {
        return backorders_allowed;
    }

    public void setBackorders_allowed(boolean backorders_allowed) {
        this.backorders_allowed = backorders_allowed;
    }

    public boolean isBackordered() {
        return backordered;
    }

    public void setBackordered(boolean backordered) {
        this.backordered = backordered;
    }

    public boolean isSold_individually() {
        return sold_individually;
    }

    public void setSold_individually(boolean sold_individually) {
        this.sold_individually = sold_individually;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Object getDimensions() {
        return dimensions;
    }

    public void setDimensions(Object dimensions) {
        this.dimensions = dimensions;
    }

    public boolean isShipping_required() {
        return shipping_required;
    }

    public void setShipping_required(boolean shipping_required) {
        this.shipping_required = shipping_required;
    }

    public boolean isShipping_taxable() {
        return shipping_taxable;
    }

    public void setShipping_taxable(boolean shipping_taxable) {
        this.shipping_taxable = shipping_taxable;
    }

    public String getShipping_class() {
        return shipping_class;
    }

    public void setShipping_class(String shipping_class) {
        this.shipping_class = shipping_class;
    }

    public int getShipping_class_id() {
        return shipping_class_id;
    }

    public void setShipping_class_id(int shipping_class_id) {
        this.shipping_class_id = shipping_class_id;
    }

    public boolean isReviews_allowed() {
        return reviews_allowed;
    }

    public void setReviews_allowed(boolean reviews_allowed) {
        this.reviews_allowed = reviews_allowed;
    }

    public String getAverage_rating() {
        return average_rating;
    }

    public void setAverage_rating(String average_rating) {
        this.average_rating = average_rating;
    }

    public int getRating_count() {
        return rating_count;
    }

    public void setRating_count(int rating_count) {
        this.rating_count = rating_count;
    }

    public ArrayList<Integer> getRelated_ids() {
        return related_ids;
    }

    public void setRelated_ids(ArrayList<Integer> related_ids) {
        this.related_ids = related_ids;
    }

    public ArrayList<Integer> getUpsell_ids() {
        return upsell_ids;
    }

    public void setUpsell_ids(ArrayList<Integer> upsell_ids) {
        this.upsell_ids = upsell_ids;
    }

    public ArrayList<Integer> getCross_sell_ids() {
        return cross_sell_ids;
    }

    public void setCross_sell_ids(ArrayList<Integer> cross_sell_ids) {
        this.cross_sell_ids = cross_sell_ids;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public String getPurchase_note() {
        return purchase_note;
    }

    public void setPurchase_note(String purchase_note) {
        this.purchase_note = purchase_note;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }

    public ArrayList<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(ArrayList<Attribute> attributes) {
        this.attributes = attributes;
    }

    public ArrayList<DefaultAttribute> getDefault_attributes() {
        return default_attributes;
    }

    public void setDefault_attributes(ArrayList<DefaultAttribute> default_attributes) {
        this.default_attributes = default_attributes;
    }

    public ArrayList<Integer> getGrouped_products() {
        return grouped_products;
    }

    public void setGrouped_products(ArrayList<Integer> grouped_products) {
        this.grouped_products = grouped_products;
    }

    public int getMenu_order() {
        return menu_order;
    }

    public void setMenu_order(int menu_order) {
        this.menu_order = menu_order;
    }

    public ArrayList<Metadata> getMeta_data() {
        return meta_data;
    }

    public void setMeta_data(ArrayList<Metadata> meta_data) {
        this.meta_data = meta_data;
    }

    public ArrayList<Image> getImages() {
        return images;
    }

    public void setImages(ArrayList<Image> images) {
        this.images = images;
    }

}

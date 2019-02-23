package me.gilo.woodroid.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class LineItem {

    public String subtotal;
    @SerializedName("subtotal_tax")
    public String subtotalTax;
    public String total;
    public String totalTax;
    public String price;
    public int quantity;
    public Object taxClass;
    public String name;

    @SerializedName("product_id")
    public int productId;

    public String sku;
    public String variations;
    public List<Metum> meta = new ArrayList<Metum>();

    public String getVariations() {
        return variations;
    }

    public void setVariations(String variations) {
        this.variations = variations;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public String getSubtotalTax() {
        return subtotalTax;
    }

    public void setSubtotalTax(String subtotalTax) {
        this.subtotalTax = subtotalTax;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(String totalTax) {
        this.totalTax = totalTax;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Object getTaxClass() {
        return taxClass;
    }

    public void setTaxClass(Object taxClass) {
        this.taxClass = taxClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public List<Metum> getMeta() {
        return meta;
    }

    public void setMeta(List<Metum> meta) {
        this.meta = meta;
    }
}

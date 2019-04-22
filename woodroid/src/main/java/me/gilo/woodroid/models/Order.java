package me.gilo.woodroid.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class Order {
    public int id;
    @SerializedName("order_number")
    public String orderNumber;
    @SerializedName("created_at")
    public String createdAt;
    @SerializedName("updated_at")
    public String updatedAt;
    @SerializedName("completed_at")
    public String completedAt;
    public String status;
    public String currency;
    public String total;
    public String subtotal;
    @SerializedName("total_line_items_quantity")
    public int totalLineItemsQuantity;
    @SerializedName("total_tax")
    public String totalTax;
    @SerializedName("total_shipping")
    public String totalShipping;
    @SerializedName("cart_tax")
    public String cartTax;
    @SerializedName("shipping_tax")
    public String shippingTax;
    @SerializedName("total_discount")
    public String totalDiscount;
    @SerializedName("shipping_methods")
    public String shippingMethods;
    @SerializedName("payment_details")
    public PaymentDetails paymentDetails;
    @SerializedName("billing")
    public BillingAddress billingAddress;
    @SerializedName("shipping")
    public ShippingAddress shippingAddress;
    public String note;
    @SerializedName("customer_ip")
    public String customerIp;
    @SerializedName("customer_user_agent")
    public String customerUserAgent;
    @SerializedName("customer_id")
    public Integer customerId;
    @SerializedName("view_order_url")
    public String viewOrderUrl;
    @SerializedName("line_items")
    public List<LineItem> lineItems = new ArrayList<LineItem>();
    @SerializedName("shipping_lines")
    public List<ShippingLine> shippingLines = new ArrayList<>();
    @SerializedName("tax_lines")
    public List<TaxLine> taxLines = new ArrayList<>();
    @SerializedName("fee_lines")
    public List<FeeLine> feeLines = new ArrayList<>();
    @SerializedName("coupon_lines")
    public List<Object> couponLines = new ArrayList<Object>();
    public Customer customer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(String completedAt) {
        this.completedAt = completedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public Integer getTotalLineItemsQuantity() {
        return totalLineItemsQuantity;
    }

    public void setTotalLineItemsQuantity(Integer totalLineItemsQuantity) {
        this.totalLineItemsQuantity = totalLineItemsQuantity;
    }

    public String getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(String totalTax) {
        this.totalTax = totalTax;
    }

    public String getTotalShipping() {
        return totalShipping;
    }

    public void setTotalShipping(String totalShipping) {
        this.totalShipping = totalShipping;
    }

    public String getCartTax() {
        return cartTax;
    }

    public void setCartTax(String cartTax) {
        this.cartTax = cartTax;
    }

    public String getShippingTax() {
        return shippingTax;
    }

    public void setShippingTax(String shippingTax) {
        this.shippingTax = shippingTax;
    }

    public String getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(String totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public String getShippingMethods() {
        return shippingMethods;
    }

    public void setShippingMethods(String shippingMethods) {
        this.shippingMethods = shippingMethods;
    }

    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCustomerIp() {
        return customerIp;
    }

    public void setCustomerIp(String customerIp) {
        this.customerIp = customerIp;
    }

    public String getCustomerUserAgent() {
        return customerUserAgent;
    }

    public void setCustomerUserAgent(String customerUserAgent) {
        this.customerUserAgent = customerUserAgent;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getViewOrderUrl() {
        return viewOrderUrl;
    }

    public void setViewOrderUrl(String viewOrderUrl) {
        this.viewOrderUrl = viewOrderUrl;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public void addLineItem(LineItem lineItem) {
        lineItems.add(lineItem);

    }

    public List<ShippingLine> getShippingLines() {
        return shippingLines;
    }

    public void setShippingLines(List<ShippingLine> shippingLines) {
        this.shippingLines = shippingLines;
    }

    public List<TaxLine> getTaxLines() {
        return taxLines;
    }

    public void setTaxLines(List<TaxLine> taxLines) {
        this.taxLines = taxLines;
    }

    public List<FeeLine> getFeeLines() {
        return feeLines;
    }

    public void setFeeLines(List<FeeLine> feeLines) {
        this.feeLines = feeLines;
    }

    public List<Object> getCouponLines() {
        return couponLines;
    }

    public void setCouponLines(List<Object> couponLines) {
        this.couponLines = couponLines;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

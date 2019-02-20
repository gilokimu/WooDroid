package me.gilo.woodroid.models.report;

import java.util.Map;

public class SalesTotal {

    private int total_discount;
    private String net_sales;
    private String total_customers;
    private Map<String, SalesPeriodTotal> totals;
    private int total_orders;
    private String total_tax;
    private int total_items;
    private String totals_grouped_by;
    private String total_shipping;
    private String average_sales;
    private String total_sales;
    private int total_refunds;

    public int getTotal_discount() {
        return total_discount;
    }

    public void setTotal_discount(int total_discount) {
        this.total_discount = total_discount;
    }

    public String getNet_sales() {
        return net_sales;
    }

    public void setNet_sales(String net_sales) {
        this.net_sales = net_sales;
    }

    public String getTotal_customers() {
        return total_customers;
    }

    public void setTotal_customers(String total_customers) {
        this.total_customers = total_customers;
    }

    public Map<String, SalesPeriodTotal> getTotals() {
        return totals;
    }

    public void setTotals(Map<String, SalesPeriodTotal> totals) {
        this.totals = totals;
    }

    public int getTotal_orders() {
        return total_orders;
    }

    public void setTotal_orders(int total_orders) {
        this.total_orders = total_orders;
    }

    public String getTotal_tax() {
        return total_tax;
    }

    public void setTotal_tax(String total_tax) {
        this.total_tax = total_tax;
    }

    public int getTotal_items() {
        return total_items;
    }

    public void setTotal_items(int total_items) {
        this.total_items = total_items;
    }

    public String getTotals_grouped_by() {
        return totals_grouped_by;
    }

    public void setTotals_grouped_by(String totals_grouped_by) {
        this.totals_grouped_by = totals_grouped_by;
    }

    public String getTotal_shipping() {
        return total_shipping;
    }

    public void setTotal_shipping(String total_shipping) {
        this.total_shipping = total_shipping;
    }

    public String getAverage_sales() {
        return average_sales;
    }

    public void setAverage_sales(String average_sales) {
        this.average_sales = average_sales;
    }

    public String getTotal_sales() {
        return total_sales;
    }

    public void setTotal_sales(String total_sales) {
        this.total_sales = total_sales;
    }

    public int getTotal_refunds() {
        return total_refunds;
    }

    public void setTotal_refunds(int total_refunds) {
        this.total_refunds = total_refunds;
    }
}

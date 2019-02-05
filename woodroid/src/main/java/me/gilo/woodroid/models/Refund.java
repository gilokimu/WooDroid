package me.gilo.woodroid.models;

public class Refund {

    private String refunded_by;
    private String reason;
    private String amount;
    private String date_created;
    private Metadata[] meta_data;
    private String date_created_gmt;
    private String id;
    private Line_item[] line_items;
    private String refunded_payment;

    public String getRefunded_by() {
        return refunded_by;
    }

    public void setRefunded_by(String refunded_by) {
        this.refunded_by = refunded_by;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }


    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public Metadata[] getMeta_data() {
        return meta_data;
    }

    public void setMeta_data(Metadata[] meta_data) {
        this.meta_data = meta_data;
    }

    public String getDate_created_gmt() {
        return date_created_gmt;
    }

    public void setDate_created_gmt(String date_created_gmt) {
        this.date_created_gmt = date_created_gmt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRefunded_payment() {
        return refunded_payment;
    }

    public void setRefunded_payment(String refunded_payment) {
        this.refunded_payment = refunded_payment;
    }

    public Line_item[] getLine_items() {
        return line_items;
    }

    public void setLine_items(Line_item[] line_items) {
        this.line_items = line_items;
    }
}




package me.gilo.woodroid.models.filters;

public class WebhookFilter extends ListFilter{

    String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        addFilter("status", status);
    }
}

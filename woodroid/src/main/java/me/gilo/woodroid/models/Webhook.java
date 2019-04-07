package me.gilo.woodroid.models;

import java.util.Date;

public class Webhook {
    int id;
    String name;
    String status;
    String topic;
    String resource;
    String event;
    String[] hooks;
    String delivery_url;
    String secret;
    Date date_created;
    Date date_created_gmt;
    Date date_modified;
    Date date_modified_gmt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String[] getHooks() {
        return hooks;
    }

    public void setHooks(String[] hooks) {
        this.hooks = hooks;
    }

    public String getDelivery_url() {
        return delivery_url;
    }

    public void setDelivery_url(String delivery_url) {
        this.delivery_url = delivery_url;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public Date getDate_created_gmt() {
        return date_created_gmt;
    }

    public void setDate_created_gmt(Date date_created_gmt) {
        this.date_created_gmt = date_created_gmt;
    }

    public Date getDate_modified() {
        return date_modified;
    }

    public void setDate_modified(Date date_modified) {
        this.date_modified = date_modified;
    }

    public Date getDate_modified_gmt() {
        return date_modified_gmt;
    }

    public void setDate_modified_gmt(Date date_modified_gmt) {
        this.date_modified_gmt = date_modified_gmt;
    }
}

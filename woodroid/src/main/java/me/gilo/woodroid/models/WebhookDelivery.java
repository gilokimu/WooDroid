package me.gilo.woodroid.models;

import java.util.Date;
import java.util.Map;

public class WebhookDelivery {

    int id;
    String duration;
    String summary;
    String request_url;
    Map<String, String> request_headers;
    String request_body;
    String response_code;
    String response_message;
    Map<String, String> response_headers;
    String response_body;
    Date date_created;
    Date date_created_gmt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getRequest_url() {
        return request_url;
    }

    public void setRequest_url(String request_url) {
        this.request_url = request_url;
    }

    public Map<String, String> getRequest_headers() {
        return request_headers;
    }

    public void setRequest_headers(Map<String, String> request_headers) {
        this.request_headers = request_headers;
    }

    public String getRequest_body() {
        return request_body;
    }

    public void setRequest_body(String request_body) {
        this.request_body = request_body;
    }

    public String getResponse_code() {
        return response_code;
    }

    public void setResponse_code(String response_code) {
        this.response_code = response_code;
    }

    public String getResponse_message() {
        return response_message;
    }

    public void setResponse_message(String response_message) {
        this.response_message = response_message;
    }

    public Map<String, String> getResponse_headers() {
        return response_headers;
    }

    public void setResponse_headers(Map<String, String> response_headers) {
        this.response_headers = response_headers;
    }

    public String getResponse_body() {
        return response_body;
    }

    public void setResponse_body(String response_body) {
        this.response_body = response_body;
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
}

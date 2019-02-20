package me.gilo.woodroid.models.filters;

public class ReportsDateFilter extends Filter{

    String period;
    String date_min;
    String date_max;

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;

        addFilter("period", period);
    }

    public String getDate_min() {
        return date_min;
    }

    public void setDate_min(String date_min) {
        this.date_min = date_min;

        addFilter("date_min", date_min);
    }

    public String getDate_max() {
        return date_max;
    }

    public void setDate_max(String date_max) {
        this.date_max = date_max;

        addFilter("date_max", date_max);
    }
}

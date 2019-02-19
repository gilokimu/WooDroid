package me.gilo.woodroid.models.filters;

public class CouponFilter extends ListFilter{

    String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
        addFilter("code", code);
    }
}

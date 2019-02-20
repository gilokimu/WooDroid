package me.gilo.woodroid.models.filters;

import java.util.HashMap;
import java.util.Map;

public class OrderNoteFilter extends  Filter{

    String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;

        addFilter("type", type);
    }
}

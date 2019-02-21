package me.gilo.woodroid.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SettingOption {

    String id;
    String option;
    String description;
    String value;

    @JsonProperty("default")
    String default_value;
    String tip;
    String placeholder;
    String type;
    String options;
    String group_id;


}

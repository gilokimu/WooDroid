package me.gilo.woodroid.models;

/**
 * Created by gilo on 1/19/16.
 */
public class Store {

    private String wc_version;
    private String description;
    private String name;
    private String URL;
    private Meta meta;

    private String version;

    public String getWc_version() {
        return wc_version;
    }

    public void setWc_version(String wc_version) {
        this.wc_version = wc_version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "ClassPojo [wc_version = " + wc_version + ", description = " + description + ", name = " + name + ", URL = " + URL + ", meta = " + meta + ", version = " + version + "]";
    }

}

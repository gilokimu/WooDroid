package me.gilo.woodroid.app.models;

import android.support.annotation.NonNull;
import com.google.firebase.firestore.IgnoreExtraProperties;
import com.google.firebase.firestore.ServerTimestamp;

import java.io.Serializable;
import java.util.Date;


/**
 * A Base Model to be extended by other models to add ids.
 */

@IgnoreExtraProperties
public class Model implements Serializable {

    public String id;

    @ServerTimestamp
    private Date date_created = null;


    public <T extends Model> T withId(@NonNull final String id) {
        this.id = id;
        return (T) this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}

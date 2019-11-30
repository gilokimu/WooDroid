package me.gilo.woodroid.app.common;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by amrro <amr.elghobary@gmail.com> on 9/15/17.
 * General interface callback for handling clicks inside {@link RecyclerView}
 */

public interface OnItemClickedListener<T> {
    void onClicked(T item);
}

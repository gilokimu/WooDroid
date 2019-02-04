package me.gilo.wc.adapter;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import me.gilo.wc.R;
import me.gilo.wc.adapter.viewholder.MenuViewHolder;

import java.util.HashMap;
import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuViewHolder> {
    private List<String> titles;

    public MenuAdapter( List<String> titles) {
        this.titles = titles;
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MenuViewHolder(parent.getContext(), LayoutInflater.from(parent.getContext()).inflate(R.layout.single_menu_item, parent, false));
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, int position) {
        holder.renderView(titles.get(position));
    }


    @Override
    public int getItemCount() {
        return titles.size() == 0 ? 0 : titles.size();
    }
}

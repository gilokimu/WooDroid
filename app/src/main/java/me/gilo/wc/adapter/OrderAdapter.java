package me.gilo.wc.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import me.gilo.wc.R;
import me.gilo.wc.adapter.viewholder.CategoryViewHolder;
import me.gilo.wc.adapter.viewholder.OrderViewHolder;
import me.gilo.woodroid.models.Category;
import me.gilo.woodroid.models.Order;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderViewHolder> {
    private List<Order> orders;

    public OrderAdapter(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public OrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new OrderViewHolder(parent.getContext(), LayoutInflater.from(parent.getContext()).inflate(R.layout.single_order_item, parent, false));
    }

    @Override
    public void onBindViewHolder(OrderViewHolder holder, int position) {
        holder.renderView(orders.get(position));
    }


    @Override
    public int getItemCount() {
        return orders.size() == 0 ? 0 : orders.size();
    }
}

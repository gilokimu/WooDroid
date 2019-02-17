package me.gilo.wc.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import me.gilo.wc.R;
import me.gilo.wc.adapter.viewholder.CouponViewHolder;
import me.gilo.woodroid.models.Coupon;

import java.util.List;

public class CouponAdapter extends RecyclerView.Adapter<CouponViewHolder> {
    private List<Coupon> coupons;

    public CouponAdapter(List<Coupon> coupons) {
        this.coupons = coupons;
    }

    @Override
    public CouponViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CouponViewHolder(parent.getContext(), LayoutInflater.from(parent.getContext()).inflate(R.layout.single_coupon_item, parent, false));
    }

    @Override
    public void onBindViewHolder(CouponViewHolder holder, int position) {
        holder.renderView(coupons.get(position));
    }


    @Override
    public int getItemCount() {
        return coupons.size() == 0 ? 0 : coupons.size();
    }
}

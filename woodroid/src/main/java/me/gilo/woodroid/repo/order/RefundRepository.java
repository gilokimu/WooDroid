package me.gilo.woodroid.repo.order;

import me.gilo.woodroid.data.api.RefundAPI;
import me.gilo.woodroid.models.Order;
import me.gilo.woodroid.models.Refund;
import me.gilo.woodroid.models.filters.RefundFilter;
import me.gilo.woodroid.repo.WooRepository;
import retrofit2.Call;

import java.util.List;

public class RefundRepository extends WooRepository {

    private final RefundAPI apiService;

    public RefundRepository(String baseUrl, String consumerKey, String consumerSecret) {
       super(baseUrl, consumerKey, consumerSecret);
       apiService = retrofit.create(RefundAPI.class);

    }

    public Call<Refund> create(Order order, Refund refund) {
        return apiService.create(order.getId(), refund);
    }

    public Call<Refund> refund(Order order, int id) {
        return apiService.view(order.getId(), id);
    }

    public Call<List<Refund>> refunds(Order order) {
        return apiService.list(order.getId());
    }

    public Call<List<Refund>> refunds(Order order, RefundFilter refundFilter) {
        return apiService.filter(order.getId(), refundFilter.getFilters());
    }

    public Call<Refund> delete(Order order, int id) {
        return apiService.delete(order.getId(), id);
    }

    public Call<Refund> delete(Order order, int id, boolean force) {
        return apiService.delete(order.getId(), id, force);
    }


}

package me.gilo.woodroid.repo.order;

import me.gilo.woodroid.data.api.OrderNoteAPI;
import me.gilo.woodroid.models.Order;
import me.gilo.woodroid.models.OrderNote;
import me.gilo.woodroid.repo.WooRepository;
import retrofit2.Call;

import java.util.List;

public class OrderNoteRepository extends WooRepository {

    private final OrderNoteAPI apiService;

    public OrderNoteRepository(String baseUrl, String consumerKey, String consumerSecret) {
       super(baseUrl, consumerKey, consumerSecret);
       apiService = retrofit.create(OrderNoteAPI.class);
    }

    public Call<OrderNote> create(Order order, OrderNote note) {
        return apiService.create(order.getId(), note);
    }

    public Call<OrderNote> note( Order order, int id) {
        return apiService.view(order.getId(), id);
    }

    public Call<List<OrderNote>> notes(Order order) {
        return apiService.list(order.getId());
    }

    public Call<OrderNote> delete(Order order, int id) {
        return apiService.delete(order.getId(), id);
    }

    public Call<OrderNote> delete(Order order, int id, boolean force) {
        return apiService.delete(order.getId(), id, force);
    }


}

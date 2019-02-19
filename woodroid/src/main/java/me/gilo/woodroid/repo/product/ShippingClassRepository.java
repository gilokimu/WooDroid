package me.gilo.woodroid.repo.product;

import me.gilo.woodroid.data.api.ShippingClassAPI;
import me.gilo.woodroid.models.ShippingClass;
import me.gilo.woodroid.models.filters.ShippingClassesFilter;
import me.gilo.woodroid.repo.WooRepository;
import retrofit2.Call;

import java.util.List;

public class ShippingClassRepository extends WooRepository {

    private final ShippingClassAPI apiService;

    public ShippingClassRepository(String baseUrl, String consumerKey, String consumerSecret) {
       super(baseUrl, consumerKey, consumerSecret);
       apiService = retrofit.create(ShippingClassAPI.class);
    }

    public Call<ShippingClass> create(ShippingClass shippingClass) {
        return apiService.create(shippingClass);
    }


    public Call<ShippingClass> shippingClass(int id) {
        return apiService.view(id);
    }

    public Call<List<ShippingClass>> shippingClasses() {
        return apiService.list();
    }

    public Call<List<ShippingClass>> shippingClasses(ShippingClassesFilter shippingClassesFilter) {
        return apiService.filter(shippingClassesFilter.getFilters());
    }

    public Call<ShippingClass> update(int id, ShippingClass shippingClass) {
        return apiService.update(id, shippingClass);
    }

    public Call<ShippingClass> delete(int id) {
        return apiService.delete(id);
    }

    public Call<ShippingClass> delete(int id, boolean force) {
        return apiService.delete(id, force);
    }


}

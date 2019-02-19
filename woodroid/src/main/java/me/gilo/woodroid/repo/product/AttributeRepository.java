package me.gilo.woodroid.repo.product;

import me.gilo.woodroid.data.api.ProductAttributeAPI;
import me.gilo.woodroid.models.Attribute;
import me.gilo.woodroid.models.filters.ProductAttributeFilter;
import me.gilo.woodroid.repo.WooRepository;
import retrofit2.Call;

import java.util.List;

public class AttributeRepository extends WooRepository {

    private final ProductAttributeAPI apiService;

    public AttributeRepository(String baseUrl, String consumerKey, String consumerSecret) {
       super(baseUrl, consumerKey, consumerSecret);
       apiService = retrofit.create(ProductAttributeAPI.class);
    }

    public Call<Attribute> create(Attribute attribute) {
        return apiService.create(attribute);
    }


    public Call<Attribute> attribute(int id) {
        return apiService.view(id);
    }

    public Call<List<Attribute>> attributes() {
        return apiService.list();
    }

    public Call<List<Attribute>> attributes(ProductAttributeFilter productAttributeFilter) {
        return apiService.filter(productAttributeFilter.getFilters());
    }

    public Call<Attribute> update(int id, Attribute attribute) {
        return apiService.update(id, attribute);
    }

    public Call<Attribute> delete(int id) {
        return apiService.delete(id);
    }

    public Call<Attribute> delete(int id, boolean force) {
        return apiService.delete(id, force);
    }


}

package me.gilo.woodroid.repo.product;

import me.gilo.woodroid.data.api.ProductAttributeTermAPI;
import me.gilo.woodroid.models.AttributeTerm;
import me.gilo.woodroid.models.filters.ProductAttributeFilter;
import me.gilo.woodroid.repo.WooRepository;
import retrofit2.Call;

import java.util.List;

public class AttributeTermRepository extends WooRepository {

    private final ProductAttributeTermAPI apiService;

    public AttributeTermRepository(String baseUrl, String consumerKey, String consumerSecret) {
       super(baseUrl, consumerKey, consumerSecret);
       apiService = retrofit.create(ProductAttributeTermAPI.class);
    }

    public Call<AttributeTerm> create(int attribute_id, AttributeTerm term) {
        return apiService.create(attribute_id, term);
    }

    public Call<AttributeTerm> term(int attribute_id, int id) {
        return apiService.view(attribute_id, id);
    }

    public Call<List<AttributeTerm>> terms(int attribute_id) {
        return apiService.list(attribute_id);
    }

    public Call<List<AttributeTerm>> terms(int attribute_id, ProductAttributeFilter productAttributeFilter) {
        return apiService.filter(attribute_id, productAttributeFilter.getFilters());
    }

    public Call<AttributeTerm> update(int attribute_id, int id, AttributeTerm term) {
        return apiService.update(attribute_id, id, term);
    }

    public Call<AttributeTerm> delete(int attribute_id, int id) {
        return apiService.delete(attribute_id, id);
    }

    public Call<AttributeTerm> delete(int attribute_id, int id, boolean force) {
        return apiService.delete(attribute_id, id, force);
    }


}

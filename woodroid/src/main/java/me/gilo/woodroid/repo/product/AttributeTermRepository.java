package me.gilo.woodroid.repo.product;

import me.gilo.woodroid.data.api.ProductAttributeTermAPI;
import me.gilo.woodroid.data.api.ProductCategoryAPI;
import me.gilo.woodroid.models.Attribute;
import me.gilo.woodroid.models.AttributeTerm;
import me.gilo.woodroid.models.Category;
import me.gilo.woodroid.repo.WooRepository;
import retrofit2.Call;

import java.util.List;

public class AttributeTermRepository extends WooRepository {

    private final ProductAttributeTermAPI apiService;

    Attribute attribute;

    public AttributeTermRepository(String baseUrl, String consumerKey, String consumerSecret, Attribute attribute) {
       super("products/categories", baseUrl, consumerKey, consumerSecret);
       apiService = retrofit.create(ProductAttributeTermAPI.class);

       this.attribute = attribute;
    }

    public Call<AttributeTerm> create(AttributeTerm term) {
        return apiService.create(term);
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public Call<AttributeTerm> term(int id) {
        return apiService.view(attribute.getId(), id);
    }

    public Call<List<AttributeTerm>> terms() {
        return apiService.list(attribute.getId());
    }

    public Call<AttributeTerm> update(int id, AttributeTerm term) {
        return apiService.update(attribute.getId(), id, term);
    }

    public Call<AttributeTerm> delete(int id) {
        return apiService.delete(attribute.getId(), id);
    }

    public Call<AttributeTerm> delete(int id, boolean force) {
        return apiService.delete(attribute.getId(), id, force);
    }


}

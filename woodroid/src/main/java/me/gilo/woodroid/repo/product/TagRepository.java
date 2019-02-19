package me.gilo.woodroid.repo.product;

import me.gilo.woodroid.data.api.ProductTagAPI;
import me.gilo.woodroid.models.Tag;
import me.gilo.woodroid.models.filters.ProductTagFilter;
import me.gilo.woodroid.repo.WooRepository;
import retrofit2.Call;

import java.util.List;

public class TagRepository extends WooRepository {

    private final ProductTagAPI apiService;

    public TagRepository(String baseUrl, String consumerKey, String consumerSecret) {
       super( baseUrl, consumerKey, consumerSecret);
       apiService = retrofit.create(ProductTagAPI.class);
    }

    public Call<Tag> create(Tag tag) {
        return apiService.create(tag);
    }


    public Call<Tag> tag(int id) {
        return apiService.view(id);
    }

    public Call<List<Tag>> tags() {
        return apiService.list();
    }

    public Call<List<Tag>> tags(ProductTagFilter productTagFilter) {
        return apiService.filter(productTagFilter.getFilters());
    }

    public Call<Tag> update(int id, Tag tag) {
        return apiService.update(id, tag);
    }

    public Call<Tag> delete(int id) {
        return apiService.delete(id);
    }

    public Call<Tag> delete(int id, boolean force) {
        return apiService.delete(id, force);
    }


}

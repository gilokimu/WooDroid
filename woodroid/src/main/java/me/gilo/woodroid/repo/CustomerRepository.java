package me.gilo.woodroid.repo;

import me.gilo.woodroid.data.api.CustomerAPI;
import me.gilo.woodroid.models.Customer;
import retrofit2.Call;

import java.util.List;

public class CustomerRepository extends WooRepository{

    private final CustomerAPI apiService;

    public CustomerRepository(String baseUrl, String consumerKey, String consumerSecret) {
       super(baseUrl, consumerKey, consumerSecret);
       apiService = retrofit.create(CustomerAPI.class);
    }

    public Call<Customer> create(Customer customer) {
        return apiService.create(customer);
    }


    public Call<Customer> customer(int id) {
        return apiService.view(id);
    }

    public Call<List<Customer>> customers() {
        return apiService.list();
    }

    public Call<Customer> update(int id, Customer customer) {
        return apiService.update(id, customer);
    }

    public Call<Customer> delete(int id) {
        return apiService.delete(id);
    }

    public Call<Customer> delete(int id, boolean force) {
        return apiService.delete(id, force);
    }


}

package me.gilo.woodroid.services;

import me.gilo.woodroid.models.Customer;
import me.gilo.woodroid.repo.CustomerRepository;
import retrofit2.Call;

import java.util.List;

public class CustomerService {

    final CustomerRepository customerRepository;

    public CustomerService(String baseUrl, String consumerKey, String consumerSecret) {
        customerRepository = new CustomerRepository(baseUrl, consumerKey, consumerSecret);
    }

    public Call<Customer> create(Customer customer) {
        return customerRepository.create(customer);
    }


    public Call<Customer> customer(int id) {
        return customerRepository.customer(id);
    }

    public Call<List<Customer>> customers() {
        return customerRepository.customers();
    }

    public Call<Customer> update(int id, Customer customer) {
        return customerRepository.update(id, customer);
    }

    public Call<Customer> delete(int id) {
        return customerRepository.delete(id);
    }

    public Call<Customer> delete(int id, boolean force) {
        return customerRepository.delete(id, force);
    }

}

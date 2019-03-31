package me.gilo.wc.viewmodels;

import android.arch.lifecycle.ViewModel;
import com.google.firebase.auth.FirebaseAuth;
import me.gilo.wc.common.WooLiveData;
import me.gilo.wc.repo.CustomerRepository;
import me.gilo.woodroid.models.Customer;
import me.gilo.woodroid.models.filters.CustomerFilter;

import javax.inject.Inject;
import java.util.List;


public final class CustomerViewModel extends ViewModel {
    private final CustomerRepository customerRepository;

    @Inject
    CustomerViewModel(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;

    }

    public WooLiveData<Customer> create(Customer customer) {
        return customerRepository.create(customer);
    }


    public WooLiveData<Customer> customer(int id) {
        return customerRepository.customer(id);
    }

    public WooLiveData<List<Customer>> currentCustomer() {
        return customerRepository.currentCustomer();
    }

    public WooLiveData<List<Customer>> customers() {
        return customerRepository.customers();
    }

    public WooLiveData<List<Customer>> customers(CustomerFilter customerFilter) {
        return customerRepository.customers(customerFilter);
    }

    public WooLiveData<Customer> update(int id, Customer customer) {
        return customerRepository.update(id, customer);
    }

    public WooLiveData<Customer> delete(int id) {
        return customerRepository.delete(id);
    }

    public WooLiveData<Customer> delete(int id, boolean force) {
        return customerRepository.delete(id, force);
    }

}
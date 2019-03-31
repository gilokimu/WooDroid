package me.gilo.wc.repo;


import com.google.firebase.auth.FirebaseAuth;
import me.gilo.wc.common.WooLiveData;
import me.gilo.woodroid.Woocommerce;
import me.gilo.woodroid.models.Customer;
import me.gilo.woodroid.models.Customer;
import me.gilo.woodroid.models.filters.CustomerFilter;

import javax.inject.Inject;
import java.util.List;

public class CustomerRepository {

    @Inject
    Woocommerce woocommerce;


    @Inject
    public CustomerRepository() {

    }

    public WooLiveData<Customer> create(Customer customer) {
        final WooLiveData<Customer> callBack = new WooLiveData();
        woocommerce.CustomerRepository().create(customer).enqueue(callBack);
        return callBack;
    }

    public WooLiveData<List<Customer>> currentCustomer() {
        final WooLiveData<List<Customer>> callBack = new WooLiveData();
        CustomerFilter customerFilter = new CustomerFilter();
        customerFilter.setEmail(FirebaseAuth.getInstance().getCurrentUser().getEmail());

        woocommerce.CustomerRepository().customers(customerFilter).enqueue(callBack);
        return callBack;
    }
    

    public WooLiveData<Customer> customer(int id) {
        final WooLiveData<Customer> callBack = new WooLiveData();
        woocommerce.CustomerRepository().customer(id).enqueue(callBack);
        return callBack;
    }

    public WooLiveData<List<Customer>> customers() {
        final WooLiveData<List<Customer>> callBack = new WooLiveData();

        woocommerce.CustomerRepository().customers().enqueue(callBack);

        return callBack;
    }

    public WooLiveData<List<Customer>> customers(CustomerFilter customerFilter) {
        final WooLiveData<List<Customer>> callBack = new WooLiveData();
        woocommerce.CustomerRepository().customers(customerFilter).enqueue(callBack);
        return callBack;
    }

    public WooLiveData<Customer> update(int id, Customer customer) {
        final WooLiveData<Customer> callBack = new WooLiveData();
        woocommerce.CustomerRepository().update(id, customer).enqueue(callBack);

        return callBack;
    }

    public WooLiveData<Customer> delete(int id) {
        final WooLiveData<Customer> callBack = new WooLiveData();
        woocommerce.CustomerRepository().delete(id).enqueue(callBack);

        return callBack;
    }

    public WooLiveData<Customer> delete(int id, boolean force) {
        final WooLiveData<Customer> callBack = new WooLiveData();
        woocommerce.CustomerRepository().delete(id, force).enqueue(callBack);

        return callBack;
    }


}

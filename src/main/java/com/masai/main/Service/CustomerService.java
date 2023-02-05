package com.masai.main.Service;

import com.masai.main.Entity.Customer;
import com.masai.main.Repository.CustomerRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepos customerRepos;

    public Customer registerCustomer(Customer customer) {
        return customerRepos.save(customer);
    }

    public Customer getCustomerByEmail(String email) {
        Optional<Customer> customer = customerRepos.findByEmail(email);
        return customer.orElse(null);
    }

    public List<Customer> getAllCustomers() {
        return customerRepos.findAll();
    }
}

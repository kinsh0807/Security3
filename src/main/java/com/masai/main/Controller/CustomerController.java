package com.masai.main.Controller;

import com.masai.main.Entity.Customer;
import com.masai.main.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    public Customer registerCustomer(@RequestBody Customer customer) {
        return customerService.registerCustomer(customer);
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {

        return customerService.getAllCustomers();
    }
}

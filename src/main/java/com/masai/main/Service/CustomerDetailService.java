package com.masai.main.Service;

import com.masai.main.Entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomerDetailService  implements UserDetailsService {
    @Autowired
    private CustomerService customerService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer customer = customerService.getCustomerByEmail(email);
        if (customer == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        return User.withUsername(customer.getEmail())
                .password(customer.getPassword())
                .roles(customer.getRole())
                .build();
    }
}

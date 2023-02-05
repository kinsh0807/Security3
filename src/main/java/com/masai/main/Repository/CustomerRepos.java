package com.masai.main.Repository;

import com.masai.main.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CustomerRepos extends JpaRepository<Customer,Integer> {
    Optional<Customer> findByEmail(String email);
}
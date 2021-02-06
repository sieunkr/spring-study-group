package com.example.demo.core.repository;

import com.example.demo.core.entity.Customer;
import com.example.demo.core.entity.CustomerId;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {

    List<Customer> findAll();
    Optional<Customer> findById(CustomerId id);
    List<Customer> findByLastName(String name);
    void save(Customer customer);
}

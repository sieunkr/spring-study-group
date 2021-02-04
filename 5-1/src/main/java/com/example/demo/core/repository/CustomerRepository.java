package com.example.demo.core.repository;

import com.example.demo.core.entity.Customer;

import java.util.Optional;

public interface CustomerRepository {
    Optional<Customer> findById(long id);
    void save(Customer customer);
}

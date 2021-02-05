package com.example.demo.core.repository;

import com.example.demo.core.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByLastName(String name);
    Optional<Customer> findByEmail(String email);


    /*
    List<Customer> findAll();
    Optional<Customer> findById(long id);
    List<Customer> findByLastName(String name);
    void save(Customer customer);

     */
}

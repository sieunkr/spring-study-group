package com.example.demo.service;

import com.example.demo.core.dto.CustomerDTO;
import com.example.demo.core.entity.Customer;
import com.example.demo.core.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerDTO findById(long id) {
        return customerRepository.findById(id).map(CustomerDTO::of)
                .orElseThrow();
    }

    public List<CustomerDTO> findAll() {
        return customerRepository.findAll().stream().map(CustomerDTO::of)
                .collect(Collectors.toList());
    }

    public List<CustomerDTO> findByName(final String name) {
        return customerRepository.findByLastName(name).stream().map(CustomerDTO::of)
                .collect(Collectors.toList());
    }


    public void save(Customer customer) {
        customerRepository.save(customer);
    }
}
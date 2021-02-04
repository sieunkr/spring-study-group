package com.example.demo.web;

import com.example.demo.core.dto.CustomerDTO;
import com.example.demo.core.entity.Customer;
import com.example.demo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/{id}")
    public CustomerDTO getOne(@PathVariable(name = "id") long id) {
        return customerService.findById(id);
    }



    @PostMapping()
    public CustomerDTO addCustomer() {

        Customer newCustomer = Customer.builder()
                .firstName("kim")
                .email("abc@test.com")
                .phone("111-1111-1111")
                .build();
        customerService.save(newCustomer);

        return CustomerDTO.of(newCustomer);
    }
}

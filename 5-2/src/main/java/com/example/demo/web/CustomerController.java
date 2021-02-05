package com.example.demo.web;

import com.example.demo.core.dto.CustomerDTO;
import com.example.demo.core.entity.Customer;
import com.example.demo.core.entity.enums.CustomerStatus;
import com.example.demo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public List<CustomerDTO> all(@RequestParam(name = "name", required = false) String name) {

        if(StringUtils.isEmpty(name)) {
            return customerService.findAll();
        } else {
            return customerService.findByName(name);
        }
    }

    @GetMapping("/{id}")
    public CustomerDTO getOne(@PathVariable(name = "id") long id) {
        return customerService.findById(id);
    }

    @PutMapping
    public CustomerDTO test() {
        return customerService.updateStatus(1L, CustomerStatus.INACTIVE);
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

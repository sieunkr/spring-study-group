package com.example.demo.core.dto;

import com.example.demo.core.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String status;

    public static CustomerDTO of(Customer customer) {
        return CustomerDTO.builder()
                .id(customer.getCustomerId().getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .status(customer.getStatus().name())
                .build();
    }

    public static CustomerDTO emptyCustomerDTO() {
        return CustomerDTO.builder().build();
    }
}
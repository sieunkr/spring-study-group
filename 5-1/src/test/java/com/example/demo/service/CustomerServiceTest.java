package com.example.demo.service;

import com.example.demo.core.dto.CustomerDTO;
import com.example.demo.core.entity.CustomerId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("h2")
class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @Test
    @DisplayName("이메일 업데이트가 잘 되는지 검증")
    void shouldUpdateCustomerEmail() {

        //given
        CustomerId customerId = new CustomerId(1L);
        var newEmail = "new-email@gmail.com";

        //when
        CustomerDTO actualCustomerDTO = customerService.updateCustomerEmail(customerId, newEmail);

        //then
        assertEquals(newEmail, customerService.findById(customerId).getEmail());
    }

}
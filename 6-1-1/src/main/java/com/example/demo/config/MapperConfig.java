package com.example.demo.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper objectMapper() {

        //실무에서는 이렇게 단순하게 사용하지 않음.
        return new ModelMapper();
    }
}

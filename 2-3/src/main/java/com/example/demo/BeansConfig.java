package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeansConfig {

    @Bean
    public MovieService movieService() {
        return new MovieService(movieRepository());
    }

    @Bean
    public MovieRepository movieRepository() {
        return new MovieRepositoryImpl(restTemplate());
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
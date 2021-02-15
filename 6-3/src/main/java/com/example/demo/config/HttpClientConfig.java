package com.example.demo.config;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HttpClientConfig {

    @Value("${http.client.connectionTimeout}")
    private int connectionTimeout;

    @Value("${http.client.readTimeout}")
    private int readTimeout;

    @Value("${http.client.maxConnection}")
    private int maxConnection;

    @Value("${http.client.maxConnPerRoute}")
    private int maxConnPerRoute;

    @Bean
    public RestTemplate restTemplate() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        HttpClient httpClient = HttpClientBuilder.create()
                .setMaxConnTotal(maxConnection)
                .setMaxConnPerRoute(maxConnPerRoute)
                .build();

        factory.setHttpClient(httpClient);
        factory.setConnectTimeout(connectionTimeout);
        factory.setReadTimeout(readTimeout);
        return new RestTemplate(factory);
    }
}
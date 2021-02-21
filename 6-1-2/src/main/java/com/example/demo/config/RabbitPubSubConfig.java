package com.example.demo.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitPubSubConfig {

    private static final String FANOUT_EXCHANGE_NAME = "movie.recommend.fanout";

    @Bean
    public FanoutExchange movieRecommendFanoutExchange() {
        return new FanoutExchange(FANOUT_EXCHANGE_NAME);
    }

    @Bean
    public Queue anonymousQueue() {
        return new AnonymousQueue();
    }

    @Bean
    public Binding binding1(FanoutExchange movieRecommendFanoutExchange, Queue anonymousQueue) {
        return BindingBuilder.bind(anonymousQueue).to(movieRecommendFanoutExchange);
    }



}

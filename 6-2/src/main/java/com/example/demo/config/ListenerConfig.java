package com.example.demo.config;

import com.example.demo.listener.RedisMessageDTOSubscriber;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@Configuration
@RequiredArgsConstructor
public class ListenerConfig {

    private final RedisMessageDTOSubscriber redisMessageDTOSubscriber;

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {

        LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory();
        return lettuceConnectionFactory;
    }

    @Bean
    RedisMessageListenerContainer redisContainer() {

        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory());
        container.addMessageListener(messageDtoListener(), topic02());
        return container;
    }

    @Bean
    MessageListenerAdapter messageDtoListener() {

        return new MessageListenerAdapter(redisMessageDTOSubscriber);
    }

    @Bean
    ChannelTopic topic02() {

        return new ChannelTopic("channel:movie");
    }
}
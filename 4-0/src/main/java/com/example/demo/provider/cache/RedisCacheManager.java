package com.example.demo.provider.cache;

import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Component("redisCacheManager")
public class RedisCacheManager implements CustomCacheManager {

    public Optional<Object> get(final String key) {
        return null;
    }

    public void put(final String key, final Object data) {
    }
}
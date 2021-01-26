package com.example.demo.provider.cache;

import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MemoryCacheManager implements CustomCacheManager {

    private ConcurrentHashMap<String, Object> cacheMap = new ConcurrentHashMap<>();

    public Optional<Object> get(final String key) {
        return Optional.ofNullable(cacheMap.get(key));
    }

    public void put(final String key, final Object data) {
        cacheMap.put(key, data);
    }
}
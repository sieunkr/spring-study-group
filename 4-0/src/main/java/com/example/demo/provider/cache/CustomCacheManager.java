package com.example.demo.provider.cache;

import java.util.Optional;

public interface CustomCacheManager {
    Optional<Object> get(final String key);
    void put(final String key, final Object data);
}
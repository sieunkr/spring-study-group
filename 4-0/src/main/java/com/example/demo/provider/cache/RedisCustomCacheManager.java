package com.example.demo.provider.cache;

import org.springframework.stereotype.Component;

import java.util.Collection;

@Component("redisCacheManager")
public class RedisCustomCacheManager implements CustomCacheManager {


    @Override
    public AbstractCustomCache getCache(String name) {
        return null;
    }

    @Override
    public Collection<String> getCacheStorageNames() {
        return null;
    }
}
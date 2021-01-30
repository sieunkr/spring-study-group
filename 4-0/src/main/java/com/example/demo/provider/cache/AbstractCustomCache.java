package com.example.demo.provider.cache;


import java.util.Optional;

public abstract class AbstractCustomCache {

    protected abstract Optional<Object> lookup(Object key);
    public abstract boolean put(String key, Object value);
    public abstract void evict(Object key);
    public abstract void clear();
}

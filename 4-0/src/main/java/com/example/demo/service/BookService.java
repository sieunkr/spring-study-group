package com.example.demo.service;

import com.example.demo.provider.cache.MemoryCaching;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BookService {

    @MemoryCaching(value = "cache::book::author", key = "author")
    public List<String> findAllByAuthor(final String author) {

        return Arrays.asList("test01", "test02");
    }

}

package com.example.demo.web;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cache")
@RequiredArgsConstructor
public class CacheController {

    private final CacheManager cacheManager;

        
    //스터디를 위해 임시로 작성한 코드.. 동작여부 확인
    @GetMapping
    public String test(@RequestParam(name = "key") String key) {
        //cacheManager.getCacheNames().stream()..
        return "ok";
    }

    @CacheEvict(value = "cache::movie::query", key = "#query")
    @DeleteMapping("/movie-query")
    public Boolean clearMovieQueryCache(@RequestParam(name = "query") String query) {
        return true;
    }

    @CacheEvict(value = "cache::movie::recommend")
    @DeleteMapping("/movie-recommend")
    public Boolean clearMovieRecommendCache() {
        return true;
    }
}
package com.example.demo.service;

import com.example.demo.core.Movie;
import com.example.demo.core.MovieGroup;
import com.example.demo.core.MovieRepository;
import com.example.demo.exception.ClientNoContentRuntimeException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    @Cacheable(value = "cache::movie::query")
    public List<Movie> search(final String query) {
        MovieGroup movieGroup = new MovieGroup(movieRepository.findByQuery(query));
        return movieGroup.getListOrderRating();
    }

    //TODO: 추후 개선 예정
    @Cacheable(value = "cache::movie::recommend")
    public Movie recommendTodayMovie() {

        var query = "반지의 제왕";
        MovieGroup movieGroup = new MovieGroup(movieRepository.findByQuery(query));

        return movieGroup.getHighestRatingMovie()
                .orElseThrow(ClientNoContentRuntimeException::new);
    }





    //스터디 준비 중.. 아래 코드 동작여부 확인해야 함..
    @CachePut(value = "cache::movie::query")
    public List<Movie> updateCache(final String query){
        MovieGroup movieGroup = new MovieGroup(movieRepository.findByQuery(query));
        return movieGroup.getListOrderRating();
    }

}
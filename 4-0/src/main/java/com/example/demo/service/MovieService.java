package com.example.demo.service;

import com.example.demo.provider.cache.LookAsideCaching;
import com.example.demo.core.Movie;
import com.example.demo.core.MovieGroup;
import com.example.demo.core.MovieRepository;
import com.example.demo.exception.ClientNoContentRuntimeException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    @LookAsideCaching(value = "cache::search-movies", key = "query")
    public List<Movie> search(final String query) {
        MovieGroup movieGroup = new MovieGroup(movieRepository.findByQuery(query));
        return movieGroup.getListOrderRating();
    }

    @LookAsideCaching(value = "cache::recommend-movie")
    public Movie recommendTodayMovie() {

        var query = "반지의 제왕"; //스터디를 위한 하드코딩.. 추후 개선 예정
        MovieGroup movieGroup = new MovieGroup(movieRepository.findByQuery(query));
        return movieGroup.getHighestRatingMovie()
                .orElseThrow(ClientNoContentRuntimeException::new);
    }
}
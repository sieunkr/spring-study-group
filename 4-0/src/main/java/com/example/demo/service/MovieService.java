package com.example.demo.service;

import com.example.demo.provider.cache.MemoryCaching;
import com.example.demo.core.Movie;
import com.example.demo.core.MovieGroup;
import com.example.demo.core.MovieRepository;
import com.example.demo.exception.ClientNoContentRuntimeException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    @MemoryCaching(value = "cache::search-movies", key = "query")
    public List<Movie> search(final String query) {
        MovieGroup movieGroup = new MovieGroup(movieRepository.findByQuery(query));
        return movieGroup.getListOrderRating();
    }

    @MemoryCaching(value = "cache::recommend-movie")
    public Movie recommendTodayMovie() {

        var query = "반지의 제왕";
        MovieGroup movieGroup = new MovieGroup(movieRepository.findByQuery(query));
        return movieGroup.getHighestRatingMovie()
                .orElseThrow(ClientNoContentRuntimeException::new);
    }
}
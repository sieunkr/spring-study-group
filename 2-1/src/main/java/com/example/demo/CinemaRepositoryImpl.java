package com.example.demo;

import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class CinemaRepositoryImpl implements MovieRepository {

    private final RestTemplate restTemplate;

    public CinemaRepositoryImpl() {
        this.restTemplate = new RestTemplate();
    }

    public List<Movie> findByQuery(final String query) {

        //하드코딩
        return Arrays.asList(
                Movie.builder().title("반지의제왕1").link("test").userRating(9.7f).build(),
                Movie.builder().title("반지의제왕2").link("test").userRating(9.4f).build(),
                Movie.builder().title("반지의제왕3").link("test").userRating(9.9f).build()
        );

    }
}

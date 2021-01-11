package com.example.demo.repository;

import com.example.demo.model.Movie;

import java.util.Arrays;
import java.util.List;

public class MovieRepositoryImpl implements MovieRepository {

    public List<Movie> findAll() {
        return Arrays.asList(
                Movie.builder().title("반지의제왕1").link("http://test").userRating(9.7f).build(),
                Movie.builder().title("반지의제왕2").link("http://test").userRating(9.8f).build()
        );
    }
}

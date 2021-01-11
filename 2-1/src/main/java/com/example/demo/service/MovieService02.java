package com.example.demo.service;

import com.example.demo.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MovieService02 {

    private final MovieRepository movieRepository;

    public MovieService02(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void printAllTitle() {
        movieRepository.findAll().forEach(m -> log.info(m.getTitle()));
    }

}

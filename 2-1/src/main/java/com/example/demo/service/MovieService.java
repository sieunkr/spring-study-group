package com.example.demo.service;

import com.example.demo.repository.MovieRepository;
import com.example.demo.repository.MovieRepositoryImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MovieService {

    public void printAllTitle() {
        MovieRepository movieRepository = new MovieRepositoryImpl();
        movieRepository.findAll().forEach(m -> log.info(m.getTitle()));
    }
}
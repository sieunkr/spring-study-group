package com.example.demo;

import java.util.List;

public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService() {
        //this.movieRepository = new MovieRepositoryImpl();
        this.movieRepository = new CinemaRepositoryImpl();
    }

    public List<Movie> search(final String query) {

        MovieGroup movieGroup = new MovieGroup(movieRepository.findByQuery(query));
        return movieGroup.getListOrderRating();
    }
}
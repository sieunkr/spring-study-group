package com.example.demo;

import java.util.List;

public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
        //this.movieRepository = new MovieRepositoryImpl();
    }

    public List<Movie> search(final String query) {

        MovieGroup movieGroup = new MovieGroup(movieRepository.findByQuery(query));
        return movieGroup.getListOrderRating();
    }
}
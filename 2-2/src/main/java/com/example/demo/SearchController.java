package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/v1/search")
public class SearchController {

    private final MovieService movieService;

    public SearchController() {
        //MovieRepository movieRepository = new MovieRepositoryImpl(new RestTemplate());
        MovieRepository movieRepository = new CinemaRepositoryImpl(new RestTemplate());
        this.movieService = new MovieService(movieRepository);
    }

    @GetMapping("/movies")
    public List<Movie> getMoviesByQuery(@RequestParam(name = "q") String query) {

        return movieService.search(query);
    }
}
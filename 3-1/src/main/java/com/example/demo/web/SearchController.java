package com.example.demo.web;

import com.example.demo.service.MovieService;
import com.example.demo.core.Movie;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/v1/search")
public class SearchController {

    private final MovieService movieService;

    public SearchController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public List<Movie> getMoviesByQuery(@RequestParam(name = "q") String query) {

        return movieService.search(query);
    }

    @GetMapping("/recommend-movie")
    public Movie getRecommendMovie() {

        return movieService.recommendTodayMovie();
    }
}
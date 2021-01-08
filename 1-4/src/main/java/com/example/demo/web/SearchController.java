package com.example.demo.web;

import com.example.demo.service.MovieService;
import com.example.demo.core.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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

}
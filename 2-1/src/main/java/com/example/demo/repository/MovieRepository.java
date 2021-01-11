package com.example.demo.repository;

import com.example.demo.model.Movie;

import java.util.Arrays;
import java.util.List;

public interface MovieRepository {

    public List<Movie> findAll();
}

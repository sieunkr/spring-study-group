package com.example.demo;

import java.util.List;

public interface MovieRepository {
    List<Movie> findByQuery(String query);
}
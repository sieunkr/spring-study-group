package com.example.demo.core;

import java.util.List;

public interface MovieRepository {
    List<Movie> findByQuery(String query);
}
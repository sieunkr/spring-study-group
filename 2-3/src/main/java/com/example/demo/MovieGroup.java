package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;

public class MovieGroup {

    private final List<Movie> list;

    public MovieGroup(final List<Movie> list) {
        this.list = list;
    }

    public List<Movie> getList() {
        return list;
    }

    public List<Movie> getListOrderRating() {
        return list.stream()
                .filter(b -> !((Float)b.getUserRating()).equals(0.0f))
                .sorted((a, b) -> b.getUserRating() > a.getUserRating() ? 1 : -1)
                .collect(Collectors.toList());
    }
}

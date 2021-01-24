package com.example.demo.core;

import java.util.List;
import java.util.Optional;
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
                .filter(b -> !((Float) b.getUserRating()).equals(0.0f))
                .sorted((a, b) -> b.getUserRating() > a.getUserRating() ? 1 : -1)
                .collect(Collectors.toList());
    }

    /*
    //* Null 처리 어려움...
    public Movie getHighestRatingMovie() {
        return getListOrderRating().get(0);
        //데이터가 없을 땐 어떻게 해야할까? Null 을 반환하면 될까?
    }
     */

    /*
    public Movie getHighestRatingMovie() {
        if(!getListOrderRating().isEmpty()) {
            return getListOrderRating().get(0);
        } else {
            return null;
        }
    }

     */


    public Optional<Movie> getHighestRatingMovie() {
        return getListOrderRating().stream().findFirst();
    }



}

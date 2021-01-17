package com.example.demo.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MovieGroupTest {

    @DisplayName("평점 순으로 정렬되는지 검증")
    @Test
    void shouldSortedInOrderOfGrade () {

        //given
        var expectedTopRankingMovieTile = "영화3";
        MovieGroup movieGroup = new MovieGroup(Arrays.asList(
                Movie.builder().title("영화1").link("http://test").userRating(9.3f).build(),
                Movie.builder().title("영화2").link("http://test").userRating(8.7f).build(),
                Movie.builder().title("영화3").link("http://test").userRating(9.7f).build()
        ));

        //when
        var actualMovieList = movieGroup.getListOrderRating();

        //then
        assertEquals(expectedTopRankingMovieTile, actualMovieList.stream().findFirst().get().getTitle());
    }
}
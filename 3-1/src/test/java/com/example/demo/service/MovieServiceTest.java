package com.example.demo.service;

import com.example.demo.core.Movie;
import com.example.demo.core.MovieRepository;
import com.example.demo.exception.ClientNoContentRuntimeException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class MovieServiceTest {


    @Mock
    private MovieRepository movieRepository;

    @DisplayName("기본 검색에서 평점 순으로 정렬되는지 검증")
    @Test
    void shouldSortedInOrderOfGrade() {

        //given
        var query = "테스트_쿼리";
        var expectedTopRankingMovieTile = "평점1위";    //평점이 제일 높을 것으로 예상되는 영화의 제목
        given(movieRepository.findByQuery(anyString())).willReturn(getStubMovies());
        MovieService movieService = new MovieService(movieRepository);

        //when
        var actualMovies = movieService.search(query);

        //then
        assertEquals(expectedTopRankingMovieTile, actualMovies.stream().findFirst().get().getTitle());
    }

    @DisplayName("평점이 0인 영화는 제외하는지 검증")
    @Test
    void shouldExcludeGradeIsZero() {

        //given
        var query = "테스트_쿼리";
        var expectedMovieSize = 3;  //0인 영화는 제외
        given(movieRepository.findByQuery(anyString())).willReturn(getStubMovies());
        MovieService movieService = new MovieService(movieRepository);

        //when
        var actualMovies = movieService.search(query);

        //then
        assertEquals(expectedMovieSize, actualMovies.size());
    }

    @DisplayName("오늘의 추천 영화로 평점이 제일 높은 영화를 제공하는 검증")
    @Test
    void shouldRecommendHighestRating() {

        //given
        var query = "테스트_쿼리";
        var expectedRecommendMovie = "평점1위";
        given(movieRepository.findByQuery(anyString())).willReturn(getStubMovies());
        MovieService movieService = new MovieService(movieRepository);

        //when
        var actualRecommendMovie = movieService.recommendTodayMovie();

        //then
        assertEquals(expectedRecommendMovie, actualRecommendMovie.getTitle());
    }

    /*
    @DisplayName("오늘의 추천 영화로 평점이 두번째 높은 영화인지 검증")
    @Test
    void shouldRecommendSecondHighestRating() {

        //given
        var query = "테스트_쿼리";
        var expectedRecommendMovie = "영화1";
        given(movieRepository.findByQuery(anyString())).willReturn(getStubMovies());
        MovieService movieService = new MovieService(movieRepository);

        //when
        var actualRecommendMovie = movieService.recommendTodayMovie();

        //then
        assertEquals(expectedRecommendMovie, actualRecommendMovie.getTitle());
    }
     */

    @Disabled
    @DisplayName("추천할 영화가 없을 때는 디폴트 영화를 제공하는지 검증")
    @Test
    void shouldDefaultMovieWhenNoneRecommend() {

        //given
        var expectedDefaultMovie = "기본영화";
        given(movieRepository.findByQuery(anyString())).willReturn(Collections.emptyList());
        MovieService movieService = new MovieService(movieRepository);

        //when
        var actualRecommendMovie = movieService.recommendTodayMovie();

        //then
        assertEquals(expectedDefaultMovie, actualRecommendMovie.getTitle());
    }


    @DisplayName("추천할 영화가 없을 때는 예외를 발생하는지 검증")
    @Test
    void shouldThrowExceptionWhenNoneRecommend() {

        //given
        given(movieRepository.findByQuery(anyString())).willReturn(Collections.emptyList());
        MovieService movieService = new MovieService(movieRepository);

        //when, then
        assertThrows(ClientNoContentRuntimeException.class, () -> {
            var movie = movieService.recommendTodayMovie();
        });
    }


    List<Movie> getStubMovies() {
        return Arrays.asList(
                Movie.builder().title("평점0").link("http://test").userRating(0.0f).build(),
                Movie.builder().title("평점2위").link("http://test").userRating(9.3f).build(),
                Movie.builder().title("평점3위").link("http://test").userRating(8.7f).build(),
                Movie.builder().title("평점1위").link("http://test").userRating(9.7f).build()
        );
    }






    /*
    //방법 1 : Mock 클래스를 직접 생성한다...
    @DisplayName("평점 순으로 정렬되는지 검증")
    @Test
    void shouldSortedInOrderOfGrade () {

        //given
        var query = "테스트_쿼리";
        var expectedTopRankingMovieTile = "영화3";    //평점이 제일 높을 것으로 예상되는 영화의 제
        MovieRepository movieRepository = new MockMovieRepositoryImpl(null, null);
        MovieService movieService = new MovieService(movieRepository);

        //when
        var actualMovies = movieService.search(query);

        //then
        assertEquals(expectedTopRankingMovieTile, actualMovies.stream().findFirst().get().getTitle());
    }

    class MockMovieRepositoryImpl extends MovieRepositoryImpl {

        public MockMovieRepositoryImpl(RestTemplate restTemplate, NaverProperties naverProperties) {
            super(restTemplate, naverProperties);
        }

        @Override
        public List<Movie> findByQuery(final String query) {
            return Arrays.asList(
                    Movie.builder().title("영화1").link("http://test").userRating(9.3f).build(),
                    Movie.builder().title("영화2").link("http://test").userRating(8.7f).build(),
                    Movie.builder().title("영화0").link("http://test").userRating(0.0f).build(),
                    Movie.builder().title("영화3").link("http://test").userRating(9.7f).build()
            );
        }
    }
     */

}
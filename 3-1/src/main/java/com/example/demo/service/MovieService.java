package com.example.demo.service;

import com.example.demo.client.ResponseMovie;
import com.example.demo.core.Movie;
import com.example.demo.core.MovieGroup;
import com.example.demo.core.MovieRepository;
import com.example.demo.exception.ClientNoContentRuntimeException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public List<Movie> search(final String query) {

        MovieGroup movieGroup = new MovieGroup(movieRepository.findByQuery(query));
        return movieGroup.getListOrderRating();
    }

    /*
    public Movie recommendTodayMovie() {
        //서비스 요구사항 = 관리자가 지정한 쿼리를 기준으로, 평점이 제일 높은 영화를 오늘의 추천영화로 제공한다..
        //임시로 하드코딩, 스터디 진행하면서 개선할 예정
        //var query = "반지의 제왕";
        var query = "스터디를 위한 테스트 쿼리(검색결과 없음)";
        MovieGroup movieGroup = new MovieGroup(movieRepository.findByQuery(query));

        if(movieGroup.getHighestRatingMovie() == null) {
            //예외 처리...
            log.error("...");
        }
        return movieGroup.getHighestRatingMovie();
    }
     */

    /*
    public Movie recommendTodayMovie() {

        var query = "스터디를 위한 테스트 쿼리(검색결과 없음)";
        //var query = "반지의 제왕";
        MovieGroup movieGroup = new MovieGroup(movieRepository.findByQuery(query));

        return movieGroup.getHighestRatingMovie()
                .orElse(Movie.builder().title("기본영화").link("http://").userRating(9.9f).build());
    }

     */

    public Movie recommendTodayMovie() {

        var query = "스터디를 위한 테스트 쿼리(검색결과 없음)";
        //var query = "반지의 제왕";
        MovieGroup movieGroup = new MovieGroup(movieRepository.findByQuery(query));

        return movieGroup.getHighestRatingMovie()
                .orElseThrow(ClientNoContentRuntimeException::new);
    }

}
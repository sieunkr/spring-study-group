package com.example.demo.service;

import com.example.demo.core.Movie;
import com.example.demo.core.MovieGroup;
import com.example.demo.core.MovieRepository;
import com.example.demo.exception.ClientNoContentRuntimeException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private String RECOMMEND_QUERY;

    @PostConstruct
    void init() {
        //TODO: DB 및 추천 검색어 초기 설정
        RECOMMEND_QUERY = "반지의 제왕";
    }

    @Cacheable(value = "cache::movie::query", key = "#query")
    public List<Movie> search(final String query) {
        MovieGroup movieGroup = new MovieGroup(movieRepository.findByQuery(query));
        return movieGroup.getListOrderRating();
    }

    //스터디를 위한 임시 상황... 캐시가 없다고 가정하자..
    //@Cacheable(value = "cache::movie::recommend")
    public Movie recommendTodayMovie(String name) {

        MovieGroup movieGroup = new MovieGroup(movieRepository.findByQuery(RECOMMEND_QUERY));

        return movieGroup.getHighestRatingMovie()
                .orElseThrow(ClientNoContentRuntimeException::new);
    }

    public void changeRecommendQuery(final String newQuery) {
        RECOMMEND_QUERY = newQuery;
    }



    //스터디 준비 중.. 아래 코드 동작여부 확인해야 함..
    @CachePut(value = "cache::movie::query")
    public List<Movie> updateCache(final String query){
        MovieGroup movieGroup = new MovieGroup(movieRepository.findByQuery(query));
        return movieGroup.getListOrderRating();
    }

}
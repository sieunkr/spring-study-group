package com.example.demo.client;

import com.example.demo.config.NaverProperties;
import com.example.demo.core.Movie;
import com.example.demo.core.MovieRepository;
import com.example.demo.exception.ClientBadRequestRuntimeException;
import com.example.demo.exception.ClientRuntimeException;
import com.example.demo.exception.ExceptionMessage;
import com.example.demo.exception.ClientAuthRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class MovieRepositoryImpl implements MovieRepository {

    private final RestTemplate restTemplate;
    private final NaverProperties naverProperties;
    private final ModelMapper modelMapper;
    private HttpHeaders httpHeaders = new HttpHeaders();

    public MovieRepositoryImpl(RestTemplate restTemplate, NaverProperties naverProperties, ModelMapper modelMapper) {
        this.restTemplate = restTemplate;
        this.naverProperties = naverProperties;
        this.modelMapper = modelMapper;

        this.httpHeaders.add("X-Naver-Client-Id", naverProperties.getClientId());
        this.httpHeaders.add("X-Naver-Client-Secret", naverProperties.getClientSecret());
    }

    public List<Movie> findByQuery(String query) {

        var url = naverProperties.getMovieUrl() + "?query=" + query;

        try {

            return restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(httpHeaders), ResponseMovie.class)
                    .getBody()
                    .getItems()
                    .stream()
                    .map(m -> modelMapper.map(m, Movie.class))
                    .collect(Collectors.toList());

        } catch (HttpClientErrorException ex) {
            if (HttpStatus.UNAUTHORIZED.equals(ex.getStatusCode())) {
                throw new ClientAuthRuntimeException(ExceptionMessage.NAVER_API_UNAUTHORIZED);
            } else if(HttpStatus.BAD_REQUEST.equals(ex.getStatusCode())) {
                throw new ClientBadRequestRuntimeException(ExceptionMessage.NAVER_API_BAD_REQUEST);
            } else {
                throw new ClientRuntimeException(ex.getMessage());
            }
        } catch (RuntimeException ex) {
            throw new ClientRuntimeException(ex.getMessage());
        }
    }
}

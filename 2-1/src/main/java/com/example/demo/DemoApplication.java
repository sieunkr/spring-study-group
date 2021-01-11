package com.example.demo;

import com.example.demo.repository.MovieRepository;
import com.example.demo.repository.MovieRepositoryImpl;
import com.example.demo.service.MovieService;
import com.example.demo.service.MovieService02;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        /*
        MovieService movieService = new MovieService();
        movieService.printAllTitle();
         */

        MovieService02 movieService02 = new MovieService02(new MovieRepositoryImpl());
        movieService02.printAllTitle();
    }
}

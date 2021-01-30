package com.example.demo.service;

import com.example.demo.core.Book;
import com.example.demo.provider.cache.LookAsideCaching;
import com.example.demo.provider.timer.PerformanceTimeRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class BookService {

    @PerformanceTimeRecord
    @LookAsideCaching(value = "cache::book::author", key = "author")
    public List<Book> findAllByAuthor(final String author) {

        try {
            Thread.sleep(3000);
            return Arrays.asList(Book.builder().title("책1").build(), Book.builder().title("책2").build());
        } catch (InterruptedException e) {
            throw new RuntimeException("test");
        }
    }


     /* AOP 를 사용하지 않는 방법
    public List<Book> findAllByAuthor(final String author) {

        try {

            long start = System.currentTimeMillis();

            //비즈니스 로직 수행 시간이라고 가정..
            Thread.sleep(3000);

            long executionTime = System.currentTimeMillis() - start;
            log.info("findAllByAuthor(String)" + " executed in " + executionTime + "ms");

            return Arrays.asList(Book.builder().title("책1").build(), Book.builder().title("책2").build());
        } catch (InterruptedException e) {
            throw new RuntimeException("test");
        }
    }

     */
}

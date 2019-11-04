package me.motyim.springbootcaching.model;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

import static javax.management.timer.Timer.ONE_SECOND;

public interface BookRepository {
    Book getByIsbn(String isbn);

    List<Book> getBooksOf(int size);

    @Cacheable("booksSizeRandom")
    List<Book> getRandomBooksOf(int size);

    @Cacheable("booksSizeRandom")
    List<Book> getRandomBooksOfWithKey(int size);

    void clearCache();
}

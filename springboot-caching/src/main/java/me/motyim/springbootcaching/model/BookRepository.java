package me.motyim.springbootcaching.model;

import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface BookRepository {
    Book getByIsbn(String isbn);

    List<Book> getBooksOf(int size);

    @Cacheable("booksSizeRandom")
    List<Book> getRandomBooksOf(int size);
}

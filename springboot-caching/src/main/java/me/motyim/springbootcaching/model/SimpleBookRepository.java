package me.motyim.springbootcaching.model;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class SimpleBookRepository implements BookRepository {

    @Override
    @Cacheable("books")
    public Book getByIsbn(String isbn) {
        simulateSlowService();
        System.out.println(">> get form method");
        return new Book(isbn, "Some book");
    }

    @Override
    @Cacheable("booksSize")
//    @CacheEvict(value="booksSize",allEntries = true)
    public List<Book> getBooksOf(int size){
        simulateSlowService();
        System.out.println(">> get form method");
        List <Book> books = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            books.add(new Book(i+"","some book"));
        }
        return books;
    }

    @Override
//    @Cacheable("booksSizeRandom")
    @CachePut("booksSizeRandom")
    public List<Book> getRandomBooksOf(int size){
        simulateSlowService();
        System.out.println(">> get form method");
        List <Book> books = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            books.add(new Book(new Random().nextInt()+"","some book"));
        }
        return books;
    }

    // Don't do this at home
    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

}

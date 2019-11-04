package me.motyim.springbootcaching.model;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static javax.management.timer.Timer.ONE_SECOND;

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
    @Cacheable("booksSizeRandom")
    // get data in every moment
//    @CachePut("booksSizeRandom")
    public List<Book> getRandomBooksOf(int size){
        simulateSlowService();
        System.out.println(">> get form method");
        List <Book> books = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            books.add(new Book(new Random().nextInt()+"","some book"));
        }
        return books;
    }


    @Override
    @Cacheable(value = "getRandomBooksOfWithKey",key = "#size")
    public List<Book> getRandomBooksOfWithKey(int size){
        simulateSlowService();
        System.out.println(">> get form method");
        List <Book> books = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            books.add(new Book(new Random().nextInt()+"","some book"));
        }
        return books;
    }

    @Override
//    @Scheduled(fixedRate = ONE_SECOND * 6)
    @CacheEvict(value = "booksSizeRandom",allEntries = true)
    public void clearCache(){
        System.out.println("CacheCleared ... ");
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

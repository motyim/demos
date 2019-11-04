package me.motyim.springbootcaching.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static javax.management.timer.Timer.ONE_SECOND;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SimpleBookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    public void fetchingIndividualsBooks(){
        System.out.println(".... Fetching books");
        System.out.println("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
        System.out.println("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567"));
        System.out.println("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
        System.out.println("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567"));
        System.out.println("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
        System.out.println("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
    }

    @Test
    public void fetchBookList(){
        System.out.println("... get books size");
        List<Book> books = bookRepository.getBooksOf(2);
        books.forEach(System.out::println);

        books = bookRepository.getBooksOf(3);
        books.forEach(System.out::println);

        books = bookRepository.getBooksOf(2);
        books.forEach(System.out::println);

        books = bookRepository.getBooksOf(3);
        books.forEach(System.out::println);
    }

    @Test
    public void fetchRandomBookList(){
        System.out.println("... get random books size");
        List<Book> books = bookRepository.getRandomBooksOf(2);
        books.forEach(System.out::println);

        books = bookRepository.getRandomBooksOf(2);
        books.forEach(System.out::println);
    }


    @Test
    public void fetchRandomBookListWithKey(){
        System.out.println("... get random books size with key");
        List<Book> books = bookRepository.getRandomBooksOfWithKey(2);
        books.forEach(System.out::println);

        books = bookRepository.getRandomBooksOfWithKey(2);
        books.forEach(System.out::println);

        books = bookRepository.getRandomBooksOfWithKey(3);
        books.forEach(System.out::println);

        books = bookRepository.getRandomBooksOfWithKey(2);
        books.forEach(System.out::println);
    }

    @Test
    public void fetchRandomWithClearCache(){
        System.out.println("... get random books size with clear");
        List<Book> books = bookRepository.getRandomBooksOf(2);
        books.forEach(System.out::println);

        try {
            System.out.println("timer Started");
            long time = ONE_SECOND*10;
            Thread.sleep(time);
            System.out.println("timer finished");
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }

        books = bookRepository.getRandomBooksOf(2);
        books.forEach(System.out::println);
    }
}
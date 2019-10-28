package me.motyim.springbootcaching.model;

public interface BookRepository {
    Book getByIsbn(String isbn);
}

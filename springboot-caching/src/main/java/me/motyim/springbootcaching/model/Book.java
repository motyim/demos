package me.motyim.springbootcaching.model;


import lombok.Data;

@Data
public class Book {
    private String isbn;
    private String title;

    public Book(){

    }

    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}

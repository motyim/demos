package me.motyim.lean.DemoGraphQL.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import graphql.GraphQLException;
import me.motyim.lean.DemoGraphQL.exception.BookNotFoundException;
import me.motyim.lean.DemoGraphQL.model.*;
import me.motyim.lean.DemoGraphQL.repository.AuthorRepository;
import me.motyim.lean.DemoGraphQL.repository.BookRepository;
import me.motyim.lean.DemoGraphQL.repository.UserRepository;

import java.util.Optional;

// TODO: 1/28/2019 make this using spring autowire
public class Mutation implements GraphQLMutationResolver {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private UserRepository userRepository;

    public Mutation(AuthorRepository authorRepository, BookRepository bookRepository,UserRepository userRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public Author newAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);

        authorRepository.save(author);

        return author;
    }

    public Book newBook(String title, String isbn, Integer pageCount, Long authorId) {
        Book book = new Book();
        book.setAuthor(new Author(authorId));
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setPageCount(pageCount != null ? pageCount : 0);

        bookRepository.save(book);

        return book;
    }

    public boolean deleteBook(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        bookRepository.delete(book.get());
        return true;
    }

    public Book updateBookPageCount(Integer pageCount, Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(!optionalBook.isPresent()) {
            throw new BookNotFoundException("The book to be updated was found", id);
        }
        Book book = optionalBook.get();
        book.setPageCount(pageCount);

        bookRepository.save(book);

        return book;
    }

    public User createUser(String name , AuthData authData){
        User user = new User();
        user.setName(name);
        user.setEmail(authData.getEmail());
        user.setPassword(authData.getPassword());
        return userRepository.save(user);
    }

    public SigninPayload signinUser(AuthData auth) {
        User user = userRepository.findByEmail(auth.getEmail());
        if (user.getPassword().equals(auth.getPassword())) {
            // TODO: 1/29/2019 make token with JWT 
            return new SigninPayload(user.getId().toString(), user);
        }
        // TODO: 1/29/2019 see exception
        throw new GraphQLException("Invalid credentials");
    }
}

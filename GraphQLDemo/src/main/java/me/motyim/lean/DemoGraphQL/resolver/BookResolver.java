package me.motyim.lean.DemoGraphQL.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import me.motyim.lean.DemoGraphQL.model.Author;
import me.motyim.lean.DemoGraphQL.model.Book;
import me.motyim.lean.DemoGraphQL.repository.AuthorRepository;

public class BookResolver implements GraphQLResolver<Book> {
    private AuthorRepository authorRepository;

    public BookResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getAuthor(Book book) {
        return authorRepository.findOne(book.getAuthor().getId());
    }
}

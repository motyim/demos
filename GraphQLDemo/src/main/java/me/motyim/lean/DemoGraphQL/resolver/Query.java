package me.motyim.lean.DemoGraphQL.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import me.motyim.lean.DemoGraphQL.model.*;
import me.motyim.lean.DemoGraphQL.repository.AuthorRepository;
import me.motyim.lean.DemoGraphQL.repository.BookRepository;

public class Query implements GraphQLQueryResolver {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public Query(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public long countBooks() {
        return bookRepository.count();
    }
    public long countAuthors() {
        return authorRepository.count();
    }
    public Info getInfo(){
        // TODO: 1/17/2019 Set this varible in appliction properties
        // TODO: 1/17/2019 make info as a  builder
        Info info = new Info();
        info.setContactEmail("mohamed.motyim@gmail.com");
        info.setContactName("MotYim");
        info.setVersion("1.0.0");
        info.setTitle("GraphQl Demo");
        info.setDescription(" A simple Demo for query and  mutation in graphql using spring boot");
        return info;
    }



}

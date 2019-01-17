package me.motyim.lean.DemoGraphQL.repository;

import me.motyim.lean.DemoGraphQL.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}

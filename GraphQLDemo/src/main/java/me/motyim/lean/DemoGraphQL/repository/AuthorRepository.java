package me.motyim.lean.DemoGraphQL.repository;

import me.motyim.lean.DemoGraphQL.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}

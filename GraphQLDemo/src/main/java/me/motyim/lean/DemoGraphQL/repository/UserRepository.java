package me.motyim.lean.DemoGraphQL.repository;

import me.motyim.lean.DemoGraphQL.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    User findByEmail(String email);
}

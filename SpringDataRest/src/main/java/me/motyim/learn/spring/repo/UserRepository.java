package me.motyim.learn.spring.repo;

import me.motyim.learn.spring.model.WebsiteUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since 22-Oct-17
 */
@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends CrudRepository<WebsiteUser, Long> {

}

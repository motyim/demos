package me.motyim.learn.swaggerserver.repo;

import me.motyim.learn.swaggerserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

/**
 * @author MA Motyim <mohamed.motyim@gmail.com>
 * @see <www.motyim.me>
 * @since 11/11/2018
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}

package me.motyim.learn.swaggerserver.service;

import me.motyim.learn.swaggerserver.model.UserModel;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author MA Motyim <mohamed.motyim@gmail.com>
 * @see <www.motyim.me>
 * @since 11/11/2018
 */
public interface UserService {

    void addUser(UserModel userModel);

    Stream<UserModel> getAllUsers();

    Optional<UserModel> getUserById(long userId);
}

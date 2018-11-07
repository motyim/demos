package me.motyim.learn.swaggerserver.apis;

import me.motyim.learn.swaggerserver.response.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author MA Motyim <mohamed.motyim@gmail.com>
 * @see <www.motyim.me>
 * @since 11/7/2018
 */
@RequestMapping("/user")
public interface UserApi {

    @GetMapping
    ResponseEntity<Response> getAllUsers();
}

package me.motyim.learn.swaggerserver.apis;

import lombok.extern.slf4j.Slf4j;
import me.motyim.learn.swaggerserver.model.User;
import me.motyim.learn.swaggerserver.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MA Motyim <mohamed.motyim@gmail.com>
 * @see <www.motyim.me>
 * @since 11/7/2018
 */
@RestController
@Slf4j
public class UserApiController implements UserApi {


    @Override
    public ResponseEntity<Response> getAllUsers() {
        User user = new User(1L, "motyim",25);
        Response response = new Response(0,"success",user);
        return new ResponseEntity<Response>(response,HttpStatus.ACCEPTED);
    }
}

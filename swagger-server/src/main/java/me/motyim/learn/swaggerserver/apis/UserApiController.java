package me.motyim.learn.swaggerserver.apis;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import me.motyim.learn.swaggerserver.model.UserModel;
import me.motyim.learn.swaggerserver.response.Response;
import me.motyim.learn.swaggerserver.response.ResponseEnum;
import me.motyim.learn.swaggerserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author MA Motyim <mohamed.motyim@gmail.com>
 * @see <www.motyim.me>
 * @since 11/7/2018
 */
@RestController
@Slf4j
public class UserApiController implements UserApi {

    @Autowired
    UserService service ;

    @Override
    public ResponseEntity<Response<UserModel>> getAllUsers() {
        log.info("Inside Get ALL Users");
        List<UserModel> allUsers = service.getAllUsers();
        Response response = new Response(ResponseEnum.SUCCESS, allUsers);
        return new ResponseEntity<Response<UserModel>>(response,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Response<Void>> AddUser(UserModel userModel) {
        log.info("Inside AddUser");
        service.addUser(userModel);
        Response response = new Response(ResponseEnum.SUCCESS, null);
        log.info("Finish AddUser");
        return new ResponseEntity<Response<Void>>(response,HttpStatus.OK);
    }
}

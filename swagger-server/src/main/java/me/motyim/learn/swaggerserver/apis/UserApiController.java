package me.motyim.learn.swaggerserver.apis;

import me.motyim.learn.swaggerserver.enums.ExceptionCode;
import me.motyim.learn.swaggerserver.exception.UserNotFoundException;
import me.motyim.learn.swaggerserver.model.UserModel;
import me.motyim.learn.swaggerserver.response.Response;
import me.motyim.learn.swaggerserver.enums.ResponseEnum;
import me.motyim.learn.swaggerserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author MA Motyim <mohamed.motyim@gmail.com>
 * @see <www.motyim.me>
 * @since 11/7/2018
 */
@RestController
public class UserApiController implements UserApi {

    @Autowired
    UserService service ;

    @Override
    public ResponseEntity<Response<List<UserModel>>> getAllUsers() {
        List<UserModel> allUsers = service.getAllUsers().collect(Collectors.toList());
        Response response = new Response(ResponseEnum.SUCCESS, allUsers);
        return new ResponseEntity<Response<List<UserModel>>>(response,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Response<Void>> AddUser(UserModel userModel) {
        service.addUser(userModel);
        Response response = new Response(ResponseEnum.SUCCESS, null);
        return new ResponseEntity<Response<Void>>(response,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Response<UserModel>> GetUserById(@PathVariable("id") int userId) {

        Optional<UserModel> user = service.getUserById(userId);

        if(!user.isPresent())
            throw new UserNotFoundException(ExceptionCode.USER_NOT_FOUND);

        Response response = new Response(ResponseEnum.SUCCESS, user.get());
        return new ResponseEntity<Response<UserModel>>(response,HttpStatus.OK);
    }
}

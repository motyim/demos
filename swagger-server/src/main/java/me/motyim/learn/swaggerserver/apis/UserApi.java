package me.motyim.learn.swaggerserver.apis;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.motyim.learn.swaggerserver.model.UserModel;
import me.motyim.learn.swaggerserver.response.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author MA Motyim <mohamed.motyim@gmail.com>
 * @see <www.motyim.me>
 * @since 11/7/2018
 */
@RequestMapping("/user")
@Api(value = "user", description = "the user API",tags = "userAPI")
public interface UserApi {

    // TODO: 11/11/2018 Make service return XML
//    @GetMapping(produces = { "application/xml", "application/json" })
    @ApiOperation(value = "Get All Users", nickname = "GetAllUsers", notes = "This can done by all users.")
    @GetMapping
    ResponseEntity<Response<UserModel>> getAllUsers();


    @PostMapping
    @ApiOperation(value = "Add New UserModel", nickname = "CreateUser", notes = "This can done by all users.")
    ResponseEntity<Response<Void>> AddUser(@RequestBody UserModel userModel);
}

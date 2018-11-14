package me.motyim.learn.swaggerserver.apis;

import io.swagger.annotations.*;
import me.motyim.learn.swaggerserver.model.UserModel;
import me.motyim.learn.swaggerserver.response.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

/**
 * @author MA Motyim <mohamed.motyim@gmail.com>
 * @see <www.motyim.me>
 * @since 11/7/2018
 */
@Validated
@RequestMapping("/users")
@Api(value = "user", description = "the user API",tags = "userAPI")
public interface UserApi {

    // TODO: 11/11/2018 Make service return XML
//    @GetMapping(produces = { "application/xml", "application/json" })
    @ApiOperation(value = "Get All Users", nickname = "GetAllUsers", notes = "This can done by all users.",position = 2)
    @GetMapping
    ResponseEntity<Response<List<UserModel>>> getAllUsers();


    @PostMapping
    @ApiOperation(value = "Add New UserModel", nickname = "CreateUser", notes = "This can done by all users.",position = 0)
    ResponseEntity<Response<Void>> AddUser(
            @ApiParam(value = "user data to be inserted",required=true) @Valid @RequestBody UserModel userModel);

    @ApiOperation(value = "Get User By Id" ,nickname = "getUser" ,position = 1)
    @GetMapping("/{id}")
    ResponseEntity<Response<UserModel>> GetUserById(
            @ApiParam(value = "id of user to gett",required=true) @PathVariable("id") @Valid @Min(0)  int id);

}

package me.motyim.learn.swaggerserver.service;

import me.motyim.learn.swaggerserver.entity.User;
import me.motyim.learn.swaggerserver.model.UserModel;
import me.motyim.learn.swaggerserver.repo.UserRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MA Motyim <mohamed.motyim@gmail.com>
 * @see <www.motyim.me>
 * @since 11/11/2018
 */
@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserRepository repository ;

    @Autowired
    DozerBeanMapper mapper;

    @Override
    public void addUser(UserModel userModel) {
        User mapedUser = mapper.map(userModel, User.class);
        repository.save(mapedUser);
    }

    @Override
    public List<UserModel> getAllUsers() {
        List<User> allUser = repository.findAll();
        List<UserModel> allUserModel = (List<UserModel>) mapper.map(allUser, ArrayList.class);
        return allUserModel;
    }
}

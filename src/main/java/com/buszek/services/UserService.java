package com.buszek.services;

import com.buszek.models.User;
import java.util.List;

public interface UserService {

    List<User> findAllUser();

    User findUserById(long id);

    User saveUser(User user);

    User updateUser(long id, User user);

    User deleteUser(long id);

}

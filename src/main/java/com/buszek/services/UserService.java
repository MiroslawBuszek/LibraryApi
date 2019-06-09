package com.buszek.services;

import com.buszek.models.User;
import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(long id);

    User save(User user);

    User update(long id, User user);

    User delete(long id);
}

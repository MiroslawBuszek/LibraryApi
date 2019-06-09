package com.buszek.repositories;

import com.buszek.models.User;
import com.buszek.services.UserService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StubUserRepository implements UserService {

    private final Map<Long, User> users = new HashMap<>();

    public StubUserRepository() {
        users.put(1L, new User(1L, "Jan", "Kowalski", "jankowalski", "jan.kowalski@gmail.com"));
        users.put(2L, new User(2L, "Piotr", "Malinowski", "piotrmalinowski", "piotr.malinowski@o2.pl"));
    }

    @Override
    public List<User> findAllUser () {
        return new ArrayList<>(users.values());
    }

    @Override
    public User findUserById (long id) {
        return users.get(id);
    }

    @Override
    public User saveUser(User user) {
        user.setId(getNextId());
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public User updateUser (long id, User user) {

        final User userToUpdate = findUserById(id);

        if (userToUpdate == null) {
            return null;
        }

        userToUpdate.updateUser(user);
        return userToUpdate;
    }

    @Override
    public User deleteUser(long id) {

        if (users.containsKey(id)) {
            return users.remove(id);
        }

        return null;
    }

    private long getNextId() {

        if (users.isEmpty()) {
            return 1L;
        }

        final List<Long> keys = new ArrayList<>(users.keySet());
        keys.sort(Comparator.reverseOrder());
        return keys.get(0) + 1L;
    }
}
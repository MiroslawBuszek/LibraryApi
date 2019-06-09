package com.buszek.controllers;

import com.buszek.models.User;
import com.buszek.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> findAllUser() {
        return userService.findAllUser();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable long id) {
        return userService.findUserById(id);
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/users/{id}")
    public User deleteUser(@PathVariable long id) {
        return userService.deleteUser(id);
    }
}

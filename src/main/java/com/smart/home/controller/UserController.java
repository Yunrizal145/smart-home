package com.smart.home.controller;

import com.smart.home.model.User;
import com.smart.home.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }


    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }
}

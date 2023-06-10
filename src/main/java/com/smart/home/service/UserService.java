package com.smart.home.service;

import com.smart.home.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUser();
    User createUser(User user);
}

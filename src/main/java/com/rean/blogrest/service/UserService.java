package com.rean.blogrest.service;

import com.rean.blogrest.model.Tag;
import com.rean.blogrest.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User updateUser(Long id, User newUser);
    List<User> getAllUsers();
    User getUserById(Long id);
    void deleteUser(Long id);
}

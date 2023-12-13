package com.rean.blogrest.service;

import com.rean.blogrest.exception.NotFoundException;
import com.rean.blogrest.model.Tag;
import com.rean.blogrest.model.User;
import com.rean.blogrest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User newUser){
        Optional<User> existingUser = userRepository.findById(id);
        existingUser.get().setName(newUser.getName());
        existingUser.get().setPassword(newUser.getPassword());
        return userRepository.save(existingUser.get());
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(()-> new NotFoundException("User not found with id: "+ id));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

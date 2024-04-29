package com.user.services.impl;

import com.user.entity.User;
import com.user.repo.UserRepository;
import com.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {

        return userRepository.findAll();

    }

    @Override
    public User getUser(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not with this id"));
        return user;
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);

    }
}

package com.app.dashboard.service;

import com.app.dashboard.entity.User;
import com.app.dashboard.exception.UserNotFoundException;
import com.app.dashboard.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(String id) {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }
}

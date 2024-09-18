package com.kamakz.kamakzbackend.service;

import com.kamakz.kamakzbackend.model.User;
import com.kamakz.kamakzbackend.repository.UserRepository;
import com.kamakz.kamakzbackend.util.HashPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final HashPassword hashPassword = new HashPassword();

    // Authenticate user by username and password
    public User authenticateUser(String username, String password) {
        // Fetch user by username
        User user = userRepository.findByUsername(username);
        if (user != null) {
            // Check if the provided password matches the stored hashed password
//            if (hashPassword.matches(password, user.getPassword())) {
//                return user;
//            }

             //Directly comparing the provided password with the stored password
            if (password.equals(user.getPassword())) {
                return user;
            }
        }
        return null;
    }

    // Fetch user by ID
    public User getUserById(Integer userId) {
        return userRepository.findById(userId).orElse(null);
    }

    // Fetch user by username
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}

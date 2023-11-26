package com.adventurer.webapp.services;

import com.adventurer.webapp.models.User;
import com.adventurer.webapp.repos.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByEmail(String email) {
        return userRepository.findUserByEmail(email).get();
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}

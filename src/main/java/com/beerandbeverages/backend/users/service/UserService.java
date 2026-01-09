package com.beerandbeverages.backend.users.service;

import com.beerandbeverages.backend.users.entity.User;
import com.beerandbeverages.backend.users.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    // === NEW METHODS (needed by edit profile) ===

    public User updateProfile(User user) {
        return userRepository.save(user);
    }

    public boolean emailExistsForOtherUser(String email, Long userId) {
        return userRepository.existsByEmailAndIdNot(email, userId);
    }

    public boolean usernameExistsForOtherUser(String username, Long userId) {
        return userRepository.existsByUsernameAndIdNot(username, userId);
    }
}

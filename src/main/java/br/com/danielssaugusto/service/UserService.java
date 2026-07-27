package br.com.danielssaugusto.service;

import br.com.danielssaugusto.entity.User;
import br.com.danielssaugusto.repository.UserRepository;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createNewUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("User already exists.");
        }
        return userRepository.save(user);
    }
}

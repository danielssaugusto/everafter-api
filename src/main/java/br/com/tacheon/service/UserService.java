package br.com.tacheon.service;

import br.com.tacheon.entity.User;
import br.com.tacheon.repository.UserRepository;

public class UserService {
    UserRepository userRepository;

    User registerUser(User user) {
        userRepository.save(user);
        return user;
    }

}

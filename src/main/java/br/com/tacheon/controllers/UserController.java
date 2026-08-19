package br.com.tacheon.controllers;

import br.com.tacheon.DTOs.UserRequestDTO;
import br.com.tacheon.DTOs.UserResponseDTO;
import br.com.tacheon.entities.User;
import br.com.tacheon.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserResponseDTO createUser(
            @RequestBody UserRequestDTO request
    ) {
        return userService.createUser(request);
    }
}

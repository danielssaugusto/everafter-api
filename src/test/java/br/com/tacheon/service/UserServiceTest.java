package br.com.tacheon.service;

import br.com.tacheon.entity.User;
import br.com.tacheon.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void register_new_user_in_the_system() {
        // ARRANGE
        User userToSave = new User();

        when(userRepository.save(any(User.class))).thenReturn(userToSave);

        // ACT
        User registeredUser = userService.registerUser(userToSave);

        // ASSERT
        assertNotNull(registeredUser, "O usuário retornado não pode ser nulo.");
        verify(userRepository, times(1)).save(userToSave);

        // CLEANUP (se necessário)
    }
}

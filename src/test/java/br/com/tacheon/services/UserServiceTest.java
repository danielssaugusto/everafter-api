package br.com.tacheon.services;

import br.com.tacheon.entities.User;
import br.com.tacheon.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
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

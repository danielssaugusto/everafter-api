package org.example.service;

import org.example.model.Wedding;
import org.example.repository.WeddingRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class WeddingServiceTest {

    @Mock
    private WeddingRepository weddingRepository;

    @InjectMocks
    private WeddingService weddingService;

    private Wedding admin;

    @BeforeEach
    void setup() {
        Long id = 1L;
        admin = new Wedding(id, "Admin", "admin@email.com", "Abc123@");
    }

    @Test
    void should_create_admin_when_email_does_not_exist() {
        // Arrange
        when(weddingRepository.existsByEmail(admin.getEmail()))
                .thenReturn(false);

        when(weddingRepository.save(admin))
                .thenReturn(admin);

        // Act
        Wedding result = weddingService.createAdminAccount(admin);

        // Assert
        Assertions.assertEquals(admin.getEmail(), result.getEmail());
    }

    @Test
    void should_throw_exception_when_email_already_exists() {
        // ARRANGE
        admin.setEmail("jhon@email.com");

        when(weddingRepository.existsByEmail(admin.getEmail()))
                .thenReturn(true);

        // ACT + ASSERT
        IllegalArgumentException exception =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> weddingService.createAdminAccount(admin)
                );

        assertEquals("Administrador email's already exists!",
                exception.getMessage());

        verify(weddingRepository, never()).save(any(Wedding.class));
    }

    @Test
    void should_update_admin_password_when_admin_already_exists() {
        // ARRANGE
        String newPassword = "123@Abc";

        when(weddingRepository.findById(admin.getId()))
                .thenReturn(Optional.of(admin));

        when(weddingRepository.save(admin))
                .thenReturn(admin);

        // ACT
        Wedding result = weddingService.updateAdminPassword(
                admin.getId(),
                newPassword);

        // ASSERT
        assertEquals(admin.getPassword(), result.getPassword());

        verify(weddingRepository).findById(admin.getId());
        verify(weddingRepository).save(admin);
    }

    @Test
    void should_not_update_admin_password_when_admin_not_exists() {
        // ARRANGE
        Long id = admin.getId();
        String newPassword = "Abc@123";

        when(weddingRepository.findById(id))
                .thenReturn(Optional.empty());

        // ACT
        IllegalArgumentException exception =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> weddingService.updateAdminPassword(id, newPassword)
                );

        // ASSERT
        assertEquals("Administrator not found!", exception.getMessage());

        verify(weddingRepository).findById(id);
        verify(weddingRepository, never()).save(any(Wedding.class));
    }

    @Test
    void should_not_save_invalid_password() {

        long id = 2L;
        String newPassword = "123";
        Wedding admin = new Wedding(id, "Admin", "admin@email.com", "Abc123@");

        when(weddingRepository.findById(id))
                .thenReturn(Optional.of(admin));

        // ACT
        IllegalArgumentException exception =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> weddingService.updateAdminPassword(id, newPassword)
                );

        // ASSERT
        assertEquals("Your password must contain at least 6 characters.", exception.getMessage());

        verify(weddingRepository).findById(id);
        verify(weddingRepository, never()).save(any(Wedding.class));
    }

    @Test
    void should_update_to_new_email_when_admin_exist() {
        // ARRANGE
        Long id = 2L;
        Wedding admin = new Wedding(id, "Admin", "admin@email.com", "Abc123@");
        String newEmail = "admin_jhon2@email.com";

        when(weddingRepository.findById(admin.getId()))
                .thenReturn(Optional.of(admin));
        when(weddingRepository.save(admin))
                .thenReturn(admin);

        // ACT
        Wedding result = weddingService.updateAdminEmail(id, newEmail);

        // ASSERT
        assertEquals(admin.getEmail(), result.getEmail());

    }
}
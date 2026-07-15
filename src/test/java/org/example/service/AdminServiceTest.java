package org.example.service;

import org.example.model.Admin;
import org.example.repository.AdminRepository;
import org.junit.jupiter.api.Assertions;
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
class AdminServiceTest {

    @Mock
    private AdminRepository adminRepository;

    @InjectMocks
    private AdminService adminService;

    @Test
    void should_create_admin_when_email_does_not_exist() {

        // Arrange
        Admin admin = new Admin();
        admin.setEmail("john@email.com");

        when(adminRepository.existsByEmail(admin.getEmail()))
                .thenReturn(false);

        when(adminRepository.save(admin))
                .thenReturn(admin);

        // Act
        Admin result = adminService.createAdminAccount(admin);

        // Assert
        Assertions.assertEquals(admin.getEmail(), result.getEmail());
    }

    @Test
    void should_throw_exception_when_email_already_exists() {
        // ARRANGE
        Admin admin = new Admin();
        admin.setEmail("jhon@email.com");

        when(adminRepository.existsByEmail(admin.getEmail()))
                .thenReturn(true);

        // ACT + ASSERT
        IllegalArgumentException exception =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> adminService.createAdminAccount(admin)
                );

        assertEquals("Administrator email already exists!",
                exception.getMessage());

        verify(adminRepository, never()).save(any(Admin.class));
    }

    @Test
    void should_update_admin_password_when_admin_already_exists() {
        // ARRANGE
        Long id = 1L;
        Admin admin = new Admin(id, "Admin", "admin@email.com", "Abc123@");
        String newPassword = "123@Abc";

        when(adminRepository.findById(id))
                .thenReturn(Optional.of(admin));

        when(adminRepository.save(admin))
                .thenReturn(admin);

        // ACT
        Admin result = adminService.updateAdminPassword(id, newPassword);

        // ASSERT
        Assertions.assertEquals(admin.getPassword(), result.getPassword());
    }

    @Test
    void should_not_update_admin_password_when_admin_not_exists() {
        // ARRANGE
        Long id = 1L;
        String newPassword = "Abc@123";

        when(adminRepository.findById(id))
                .thenReturn(Optional.empty());

        // ACT
        IllegalArgumentException exception =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> adminService.updateAdminPassword(id, newPassword)
                );

        // ASSERT
        assertEquals("Administrator not found.", exception.getMessage());

        verify(adminRepository).findById(id);
        verify(adminRepository, never()).save(any(Admin.class));
    }

    @Test
    void should_not_save_invalid_password() {

        long id = 2L;
        String newPassword = "123";
        Admin admin = new Admin(id, "Admin", "admin@email.com", "Abc123@");

        when(adminRepository.findById(id))
                .thenReturn(Optional.of(admin));

        // ACT
        IllegalArgumentException exception =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> adminService.updateAdminPassword(id, newPassword)
                );

        // ASSERT
        assertEquals("Your password must contain at least 6 characters.", exception.getMessage());

        verify(adminRepository).findById(id);
        verify(adminRepository, never()).save(any(Admin.class));
    }

    @Test
    void should_update_to_new_email_when_admin_exist() {
        // ARRANGE
        Long id = 2L;
        Admin admin = new Admin(id, "Admin", "admin@email.com", "Abc123@");
        String newEmail = "admin_jhon2@email.com";

        when(adminRepository.findById(admin.getId()))
                .thenReturn(Optional.of(admin));
        when(adminRepository.save(admin))
                .thenReturn(admin);

        // ACT
        Admin result = adminService.updateAdminEmail(id, newEmail);

        // ASSERT
        assertEquals(admin.getEmail(), result.getEmail());

    }
}
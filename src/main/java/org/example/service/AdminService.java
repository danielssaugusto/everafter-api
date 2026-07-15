package org.example.service;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.example.model.Admin;
import org.example.repository.AdminRepository;

import java.util.List;

public class AdminService {

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Admin createAdminAccount(Admin admin) {
        if (adminRepository.existsByEmail(admin.getEmail())) {
            throw new IllegalArgumentException("Administrador email's already exists!");
        }
        return adminRepository.save(admin);
    }

    public Admin updateAdminPassword(Long id, String newPassword) {
        Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Administrator not found!"));

        if (newPassword == null || newPassword.trim().length() < 6) {
            throw new IllegalArgumentException("Your password must contain at least 6 characters.");
        }

        admin.setPassword(newPassword);
        return adminRepository.save(admin);
    }

    public Admin updateAdminEmail(String newEmail) {
        Admin admin = adminRepository.findByEmail(newEmail);
        admin.setEmail(newEmail);
        return adminRepository.save(admin);
    }

    public
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    String findByEmail(String email) {
        Admin admin = adminRepository.findByEmail(email);
        if (admin != null) {
            return admin.getEmail();
        }
        return null;
    }

    public List<Admin> findAll() {
        return adminRepository.findAll();
    }
}

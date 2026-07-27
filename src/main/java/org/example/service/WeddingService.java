package org.example.service;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.example.model.Wedding;
import org.example.repository.WeddingRepository;

import java.util.List;

public class WeddingService {

    private final WeddingRepository weddingRepository;

    public WeddingService(WeddingRepository weddingRepository) {
        this.weddingRepository = weddingRepository;
    }

    public Wedding createAdminAccount(Wedding admin) {
        if (weddingRepository.existsByEmail(admin.getEmail())) {
            throw new IllegalArgumentException("Administrador email's already exists!");
        }
        return weddingRepository.save(admin);
    }

    public Wedding updateAdminPassword(Long id, String newPassword) {
        Wedding wedding = weddingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Administrator not found!"));

        if (newPassword == null || newPassword.trim().length() < 6) {
            throw new IllegalArgumentException("Your password must contain at least 6 characters.");
        }

        wedding.setPassword(newPassword);
        return weddingRepository.save(wedding);
    }

    public Wedding updateAdminEmail(Long id, String newEmail) {
        Wedding admin = weddingRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("Administrator not found!"));

        if (newEmail == null) {
            throw new IllegalArgumentException("Your email not be null.");
        }

        admin.setEmail(newEmail);
        return weddingRepository.save(admin);
    }

    public
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    String findByEmail(String email) {
        Wedding wedding = weddingRepository.findByEmail(email);
        if (wedding != null) {
            return wedding.getEmail();
        }
        return null;
    }

    public List<Wedding> findAll() {
        return weddingRepository.findAll();
    }
}

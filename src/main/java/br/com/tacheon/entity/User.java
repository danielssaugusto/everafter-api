package br.com.tacheon.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
public class User {
    private UUID userId;
    private String username;
    private String email;
    private String password;
    private String phone;
    private LocalDate initDate;
    private LocalDate updateData;
    private boolean active = true;

    public User(
            String username,
            String email,
            String password,
            String phone,
            LocalDate initDate,
            LocalDate updateData,
            boolean active) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.initDate = initDate;
        this.updateData = updateData;
        this.active = active;
    }
}

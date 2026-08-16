package br.com.tacheon.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private UUID userId;
    private String username;
    private String email;
    private String password;
    private String phone;
    private LocalDate initDate;
    private LocalDate updateData;
    private boolean active = true;

    @OneToMany(mappedBy = "user")
    private List<WeddingParticipation> weddingParticipations = new ArrayList<>();

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

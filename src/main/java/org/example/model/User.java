package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Entity
@Setter
@Getter
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // ou JOINED
@DiscriminatorColumn(name = "role", discriminatorType = DiscriminatorType.STRING)
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String fullName;

    @Setter
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    public User(Long id, String fullName, String email, String password) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }

    public User() {

    }

    public abstract Role getRole();

    public void setPassword(String password) {
        if (!password.isBlank()) {
            this.password = password;
        }
    }

    public void setFullName(String fullName) {
        if (!fullName.isBlank() && fullName.length() >= 5) {
            this.fullName = fullName;
        }
    }

    @Setter
    @Enumerated(EnumType.STRING)
    private RSVPStatus status;

}

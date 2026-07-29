package br.com.danielssaugusto.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public abstract class User {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String email;
    private String password;

    protected User() {

    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}

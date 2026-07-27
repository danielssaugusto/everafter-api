package br.com.danielssaugusto.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public abstract class User {
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

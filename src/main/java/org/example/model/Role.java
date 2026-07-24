package org.example.model;

import lombok.Getter;

@Getter
public enum Role {
    ADMIN(1, "Noivo(a)"),
    PROFESSIONAL(2, "Cerimonialista"),
    GUEST(3, "Convidado(a)");

    final private int code;
    final private String description;

    Role(int code, String description) {
        this.code = code;
        this.description = description;
    }
}

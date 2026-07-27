package org.example.enums;

import lombok.Getter;

@Getter
public enum Role {
    GROOM(1, "Groom"),
    BRIDE(2, "Bride"),
    PROFESSIONAL(3, "Cerimonialista"),
    GUEST(4, "Convidado(a)");

    final private int code;
    final private String description;

    Role(int code, String description) {
        this.code = code;
        this.description = description;
    }
}

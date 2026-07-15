package org.example.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends User {

    public Admin() {
        super();
    }

    public Admin(Long id, String fullName, String email, String password) {
        super(id, fullName, email, password);
    }

    @Override
    public Role getRole() {
        return Role.ADMIN;
    }
}

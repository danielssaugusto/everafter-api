package org.example.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.example.enums.Role;

import java.util.List;

@Getter
@Setter
@Entity
public class Wedding extends User{
    @ManyToOne
    @JoinColumn(name = "groom_id")
    private User groom;

    @ManyToOne
    @JoinColumn(name = "bride_id")
    private User bride;

    private List<Guest> guests;

    public Wedding(Long id, String fullName, String email, String password) {
        super(id, fullName, email, password);
    }

    @Override
    public Role getRole() {
        return null;
    }
}

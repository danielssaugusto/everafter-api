package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/* * Status
* Attending
* Not Attending
* Pending
* Declined
* */

@Entity
@Setter
@Getter
@DiscriminatorValue("GUEST")
public class Guest {
    @Enumerated(EnumType.STRING)
    private RSVPStatus status = RSVPStatus.PENDING;
    private Role role = Role.GUEST;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;

    public Guest(Long id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public Role getRole() {
        return Role.GUEST;
    }

    public void setStatus(RSVPStatus status) {
        this.status = status;
    }
}

package br.com.tacheon.entity;

import br.com.tacheon.enums.WeddingRole;
import jakarta.persistence.*;
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
public class WeddingParticipation {
    @Id
    @GeneratedValue
    private UUID weddingRoleId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "wedding_id")
    private Wedding wedding;


    private WeddingRole weddingRole;
    private LocalDate initDate;
    private boolean active = true;



    public WeddingParticipation(
            User user,
            Wedding wedding,
            WeddingRole weddingRole,
            LocalDate initDate,
            boolean active) {
        this.user = user;
        this.wedding = wedding;
        this.weddingRole = weddingRole;
        this.initDate = initDate;
        this.active = active;
    }
}
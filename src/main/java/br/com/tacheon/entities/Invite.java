package br.com.tacheon.entities;

import br.com.tacheon.enums.InviteStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Invite {
    @Id
    @GeneratedValue
    private UUID inviteId;

    @ManyToOne
    @JoinColumn(name = "wedding_id")
    private Wedding wedding;

    @OneToOne
    @JoinColumn(name = "family_id", unique = true)
    private Family family;

    @OneToMany(mappedBy = "wedding")
    private List<Guest> guests = new ArrayList<>();

    private Long code;
    private InviteStatus status;
    private LocalDateTime sendDate;
    private LocalDateTime acceptedDate;
    private LocalDateTime expiredDate;

    public Invite(Wedding wedding,
                  Family family,
                  Long code,
                  InviteStatus status,
                  LocalDateTime sendDate,
                  LocalDateTime acceptedDate,
                  LocalDateTime expiredDate) {
        this.wedding = wedding;
        this.family = family;
        this.code = code;
        this.status = status;
        this.sendDate = sendDate;
        this.acceptedDate = acceptedDate;
        this.expiredDate = expiredDate;
    }
}
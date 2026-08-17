package br.com.tacheon.entity;

import br.com.tacheon.enums.InviteStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    private Family familyId;

    @OneToMany(mappedBy = "guest_id")
    private Guest guest;

    private Long code;
    private InviteStatus status;
    private LocalDateTime sendDate;
    private LocalDateTime acceptedDate;
    private LocalDateTime expiredDate;

    public Invite(Wedding wedding,
                  Family familyId,
                  Long code,
                  InviteStatus status,
                  LocalDateTime sendDate,
                  LocalDateTime acceptedDate,
                  LocalDateTime expiredDate) {
        this.wedding = wedding;
        this.familyId = familyId;
        this.code = code;
        this.status = status;
        this.sendDate = sendDate;
        this.acceptedDate = acceptedDate;
        this.expiredDate = expiredDate;
    }
}
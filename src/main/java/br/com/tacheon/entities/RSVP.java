package br.com.tacheon.entities;

import br.com.tacheon.enums.RSVPStatus;
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
public class RSVP {
    @Id
    @GeneratedValue
    private UUID rsvpId;

    @OneToOne
    @JoinColumn(name = "guest_id", unique = true)
    private Guest guest;

    @ManyToOne
    @JoinColumn(name = "invite_id")
    private Invite invite;

    private RSVPStatus status;
    private LocalDateTime answerDate;
    private LocalDate updateDate;

    public RSVP(
            Guest guest,
            Invite invite,
            RSVPStatus status,
            LocalDateTime answerDate,
            LocalDate updateDate) {
        this.guest = guest;
        this.invite = invite;
        this.status = status;
        this.answerDate = answerDate;
        this.updateDate = updateDate;
    }
}
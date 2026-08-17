package br.com.tacheon.entity;

import br.com.tacheon.enums.AgeClassification;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Guest {

    @Id
    @GeneratedValue
    private UUID guestID;

    @ManyToOne
    @JoinColumn(name = "family_id")
    private Family family;

    private String guestName;
    private String phone;
    private AgeClassification guestType;

    @OneToOne(mappedBy = "rsvp_id")
    private RSVP rsvp;

    private LocalDate initDate;
    private LocalDate updateDate;

    @ManyToOne
    @JoinColumn(name = "invite_id")
    private Invite invite;

    public Guest(
            Family family,
            String guestName,
            String phone,
            AgeClassification guestType,
            LocalDate initDate,
            LocalDate updateDate) {
        this.family = family;
        this.guestName = guestName;
        this.phone = phone;
        this.guestType = guestType;
        this.initDate = initDate;
        this.updateDate = updateDate;
    }
}
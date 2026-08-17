package br.com.tacheon.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Wedding {
    @Id
    @GeneratedValue
    private UUID eventId;
    private String eventTitle;
    private LocalDate eventDate;
    private LocalTime eventSchedule;
    private String eventVenue;
    private LocalDate initDate;
    private LocalDate updateDate;
    private boolean active = true;

    @OneToMany(mappedBy = "wedding")
    private List<WeddingParticipation> weddingParticipation = new ArrayList<>();

    @OneToMany(mappedBy = "wedding")
    private List<Family> family = new ArrayList<>();

    @OneToMany(mappedBy = "wedding")
    private Invite invite;

    public Wedding(
            String eventTitle,
            LocalDate eventDate,
            LocalTime eventSchedule,
            String eventVenue,
            LocalDate initDate,
            LocalDate updateDate,
            boolean active) {
        this.eventTitle = eventTitle;
        this.eventDate = eventDate;
        this.eventSchedule = eventSchedule;
        this.eventVenue = eventVenue;
        this.initDate = initDate;
        this.updateDate = updateDate;
        this.active = active;
    }
}

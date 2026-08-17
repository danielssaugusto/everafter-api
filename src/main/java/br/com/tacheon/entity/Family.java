package br.com.tacheon.entity;

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
public class Family {
    @Id
    @GeneratedValue
    private UUID familyId;

    @ManyToOne
    @JoinColumn(name = "wedding_id")
    private Wedding wedding;


    private String familyName;
    private LocalDate initDate;
    private LocalDate updateDate;

    public Family(
            Wedding wedding,
            String familyName,
            LocalDate initDate,
            LocalDate updateDate) {
        this.wedding = wedding;
        this.familyName = familyName;
        this.initDate = initDate;
        this.updateDate = updateDate;
    }
}
package br.com.tacheon.entity;

import br.com.tacheon.enums.AgeClassification;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
    private Family family;
    private String guestName;
    private String phone;
    private AgeClassification guestType;
    private LocalDate initDate;
    private LocalDate updateDate;

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
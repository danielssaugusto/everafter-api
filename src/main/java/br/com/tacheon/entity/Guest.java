package br.com.tacheon.entity;

import br.com.tacheon.enums.AgeClassification;

import java.time.LocalDate;
import java.util.UUID;

public class Guest {
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
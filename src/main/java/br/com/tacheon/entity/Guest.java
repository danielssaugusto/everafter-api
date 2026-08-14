package br.com.tacheon.entity;

import br.com.tacheon.enums.AgeClassification;

import java.time.LocalDate;
import java.util.UUID;

public class Guest {
    private UUID guestID;
    private Family familyId;
    private String guestName;
    private String phone;
    private AgeClassification guestType;
    private LocalDate initDate;
    private LocalDate updateDate;

    public Guest(
            Family familyId,
            String guestName,
            String phone,
            AgeClassification guestType,
            LocalDate initDate,
            LocalDate updateDate) {
        this.familyId = familyId;
        this.guestName = guestName;
        this.phone = phone;
        this.guestType = guestType;
        this.initDate = initDate;
        this.updateDate = updateDate;
    }
}
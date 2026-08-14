package br.com.tacheon.entity;

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
public class Family {
    @Id
    @GeneratedValue
    private UUID familyId;
    private Wedding weddingId;
    private String familyName;
    private LocalDate initDate;
    private LocalDate updateDate;

    public Family(
            Wedding weddingId,
            String familyName,
            LocalDate initDate,
            LocalDate updateDate) {
        this.weddingId = weddingId;
        this.familyName = familyName;
        this.initDate = initDate;
        this.updateDate = updateDate;
    }
}
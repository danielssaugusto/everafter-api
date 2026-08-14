package br.com.tacheon.entity;

import br.com.tacheon.enums.InviteStatus;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Invite {
    private UUID inviteId;
    private Wedding wedding;
    private Family familyId;
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
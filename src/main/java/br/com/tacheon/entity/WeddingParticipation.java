package br.com.tacheon.entity;

import br.com.tacheon.enums.WeddingRole;
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
public class WeddingParticipation {
    @Id
    @GeneratedValue
    private UUID weddingRoleId;
    private User userId;
    private Wedding weddingId;
    private WeddingRole weddingRole;
    private LocalDate initDate;
    private boolean active = true;

    public WeddingParticipation(
            User userId,
            Wedding weddingId,
            WeddingRole weddingRole,
            LocalDate initDate,
            boolean active) {
        this.userId = userId;
        this.weddingId = weddingId;
        this.weddingRole = weddingRole;
        this.initDate = initDate;
        this.active = active;
    }
}
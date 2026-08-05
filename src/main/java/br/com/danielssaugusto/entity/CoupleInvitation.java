package br.com.danielssaugusto.entity;

import br.com.danielssaugusto.enums.InvitationPartnerStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Entity
@Getter
@Setter
public class CoupleInvitation {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    private CoupleMember sender;

    @Column(nullable = false)
    private String invitedEmail;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InvitationPartnerStatus status;

    @Column(nullable = false, unique = true)
    private String token;
}
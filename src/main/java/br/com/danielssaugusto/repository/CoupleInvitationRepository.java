package br.com.danielssaugusto.repository;

import br.com.danielssaugusto.entity.CoupleInvitation;
import br.com.danielssaugusto.enums.InvitationPartnerStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CoupleInvitationRepository extends JpaRepository<CoupleInvitation, UUID> {

    Optional<CoupleInvitation> findByToken(String token);

    Optional<CoupleInvitation> findByInvitedEmail(String invitedEmail);

    boolean existsByInvitedEmailAndStatus(
            String invitedEmail,
            InvitationPartnerStatus status
    );
}

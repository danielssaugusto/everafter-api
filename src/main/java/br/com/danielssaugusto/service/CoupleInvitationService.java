package br.com.danielssaugusto.service;

import br.com.danielssaugusto.entity.CoupleInvitation;
import br.com.danielssaugusto.entity.CoupleMember;
import br.com.danielssaugusto.enums.InvitationPartnerStatus;
import br.com.danielssaugusto.repository.CoupleInvitationRepository;
import br.com.danielssaugusto.repository.CoupleMemberRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public class CoupleInvitationService {

    CoupleMemberRepository coupleMemberRepository;
    CoupleInvitationRepository coupleInvitationRepository;

    @Transactional
    public CoupleInvitation invitePartner(UUID senderId, String invitedEmail) {

        CoupleMember sender = coupleMemberRepository.findById(senderId)
                .orElseThrow(() ->
                        new IllegalArgumentException("Sender not found"));

        if (coupleInvitationRepository.existsByInvitedEmailAndStatus(
                invitedEmail,
                InvitationPartnerStatus.PENDING)) {

            throw new IllegalArgumentException(
                    "There is already a pending invitation for this email."
            );
        }

        CoupleInvitation invitation = new CoupleInvitation();

        invitation.setSender(sender);
        invitation.setInvitedEmail(invitedEmail);
        invitation.setStatus(InvitationPartnerStatus.PENDING);
        invitation.setToken(UUID.randomUUID().toString());

        return coupleInvitationRepository.save(invitation);
    }
}

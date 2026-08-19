package br.com.tacheon.services;

import br.com.tacheon.entities.Invite;
import br.com.tacheon.entities.User;
import br.com.tacheon.entities.Wedding;
import br.com.tacheon.entities.WeddingParticipation;
import br.com.tacheon.repositories.InviteRepository;
import br.com.tacheon.repositories.UserRepository;
import br.com.tacheon.repositories.WeddingParticipationRepository;

import java.util.UUID;

public class WeddingParticipationService {

    private final UserRepository userRepository;
    private final InviteRepository inviteRepository;
    private final WeddingParticipationRepository weddingParticipationRepository;

    public WeddingParticipationService(
            UserRepository userRepository,
            InviteRepository inviteRepository,
            WeddingParticipationRepository weddingParticipationRepository) {
        this.userRepository = userRepository;
        this.inviteRepository = inviteRepository;
        this.weddingParticipationRepository = weddingParticipationRepository;
    }

    public WeddingParticipation acceptInvite(UUID userId, UUID inviteId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found."));

        Invite invite = inviteRepository.findById(inviteId)
                .orElseThrow(() -> new RuntimeException("Invite not found."));

        Wedding wedding = invite.getWedding();

        if (weddingParticipationRepository.existsByUserAndWedding(user, wedding)) {
            throw new RuntimeException("User already participates in this wedding.");
        }

        WeddingParticipation weddingParticipation = new WeddingParticipation();

        weddingParticipation.setUser(user);
        weddingParticipation.setWedding(wedding);

        return weddingParticipationRepository.save(weddingParticipation);
    }
}

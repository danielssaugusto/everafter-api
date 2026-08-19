package br.com.tacheon.services;

import br.com.tacheon.entities.Invite;
import br.com.tacheon.repositories.InviteRepository;

import java.util.UUID;

public class InviteService {
    private final InviteRepository inviteRepository;

    public InviteService(InviteRepository inviteRepository) {
        this.inviteRepository = inviteRepository;
    }

    private final Invite findInvite(UUID id) {
        Invite invite = inviteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invite not found."));

        return invite;
    }

    // create invite
    public Invite createInvite(UUID inviteId) {
        Invite invite = findInvite(inviteId);

        return inviteRepository.save(invite);
    }

    // send invite

    // cancel invite

    // search invite


}

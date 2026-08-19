package br.com.tacheon.services;

import br.com.tacheon.entities.Invite;
import br.com.tacheon.entities.InviteMessage;
import br.com.tacheon.repositories.InviteRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class InviteService {
    private final InviteRepository inviteRepository;
    private final MessageService messageService;

    public InviteService(
            InviteRepository inviteRepository,
            MessageService messageService
    ) {
        this.inviteRepository = inviteRepository;
        this.messageService = messageService;
    }

    public Invite findInvite(UUID id) {
        return inviteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invite not found."));
    }

    public Invite createInvite(UUID id) {
        Invite invite = findInvite(id);

        return inviteRepository.save(invite);
    }

    public void sendInvite(UUID inviteId, InviteMessage inviteMessage) {

        Invite invite = inviteRepository.findById(inviteId)
                .orElseThrow(() -> new RuntimeException("Invite not found."));

        messageService.send(inviteMessage);
    }

    public void cancelInvite(UUID id) {
        Invite invite = inviteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invite not found."));

        inviteRepository.delete(invite);
    }
}

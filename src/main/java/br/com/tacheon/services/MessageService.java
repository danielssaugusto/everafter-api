package br.com.tacheon.services;

import br.com.tacheon.entities.InviteMessage;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final EmailService emailService;

    public MessageService(EmailService emailService) {
        this.emailService = emailService;
    }


    public void send(InviteMessage inviteMessage) {

        switch (inviteMessage.getType()) {
            case EMAIL -> emailService.send(
                    inviteMessage.getContact(),
                    inviteMessage.getMessage()
            );

            case PHONE, WHATSAPP -> {
                throw new UnsupportedOperationException(
                        "This contact type is not supported yet."
                );
            }
        }
    }
}
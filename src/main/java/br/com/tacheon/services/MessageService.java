package br.com.tacheon.services;

import br.com.tacheon.entities.InviteMessage;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public void send(InviteMessage inviteMessage) {

        switch (inviteMessage.getType()) {
            case EMAIL -> {
                // enviar email
            }

            case PHONE -> {
                // enviar SMS
            }

            case WHATSAPP -> {
                // enviar WhatsApp
            }
        }
    }
}
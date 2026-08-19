package br.com.tacheon.entities;

import br.com.tacheon.enums.ContactType;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class InviteMessage {

    private String contact;
    private ContactType type;
    private String message;

    public InviteMessage(String contact, ContactType type, String message) {
        this.contact = contact;
        this.type = type;
        this.message = message;
    }

    public String getContact() {
        return contact;
    }

    public ContactType getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

}

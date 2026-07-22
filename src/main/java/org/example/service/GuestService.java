package org.example.service;

import org.example.model.Guest;
import org.example.repository.GuestRepository;

public class GuestService {

    private final GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public void confirmPresence(Guest guest) {

    }
}
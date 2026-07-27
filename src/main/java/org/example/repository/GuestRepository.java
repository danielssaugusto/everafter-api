package org.example.repository;

import org.example.model.Guest;
import org.example.enums.RSVPStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuestRepository extends JpaRepository<Guest, Long> {
    List<Guest> findByStatus(RSVPStatus status);
    boolean existsByEmail(String email);
}

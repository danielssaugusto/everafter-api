package br.com.tacheon.repositories;

import br.com.tacheon.entities.WeddingParticipation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WeddingParticipationRepository extends JpaRepository<UUID, WeddingParticipation> {
}

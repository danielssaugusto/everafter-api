package org.example.repository;

import org.example.model.Wedding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeddingRepository extends JpaRepository<Wedding, Long> {
    boolean existsByEmail(String email);
    Wedding findByEmail(String email);
}

package br.com.danielssaugusto.repository;


import br.com.danielssaugusto.entity.Couple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CoupleRepository extends JpaRepository<Couple, UUID> {
    boolean existsByGroomEmail(String email);

}

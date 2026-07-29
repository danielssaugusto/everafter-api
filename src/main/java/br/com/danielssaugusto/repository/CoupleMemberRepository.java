package br.com.danielssaugusto.repository;

import br.com.danielssaugusto.entity.CoupleMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CoupleMemberRepository extends JpaRepository<CoupleMember, UUID> {
    boolean existsByEmail(String email);

    Optional<CoupleMember> findByEmail(String email);

}

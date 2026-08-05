package br.com.danielssaugusto.repository;

import br.com.danielssaugusto.entity.CoupleMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CoupleMemberRepository extends JpaRepository<CoupleMember, UUID> {

    boolean existsByEmail(String email);

    Optional<CoupleMember> findByEmail(String email);

}

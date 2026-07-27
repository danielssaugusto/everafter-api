package br.com.danielssaugusto.repository;

import br.com.danielssaugusto.entity.Couple;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CoupleRepository extends JpaRepository<Couple, UUID> {

}

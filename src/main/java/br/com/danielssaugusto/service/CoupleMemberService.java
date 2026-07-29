package br.com.danielssaugusto.service;

import br.com.danielssaugusto.entity.CoupleMember;
import br.com.danielssaugusto.repository.CoupleMemberRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

public class CoupleMemberService {
    CoupleMemberRepository coupleMemberRepository;
    Optional<CoupleMember> coupleMember;

    @Transactional
    public Optional<CoupleMember> updateCoupleMemberEmail(UUID id, String email) {
        coupleMember = Optional.of(coupleMemberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Couple member not found.")));

        coupleMember.get().setEmail(email);

        return coupleMember;
    }

    @Transactional
    public Optional<CoupleMember> updateCoupleMemberPassword(UUID id, String password) {
        coupleMember = Optional.of(coupleMemberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Couple member not found")));
        coupleMember.get().setEmail(password);

        return coupleMember;
    }


}

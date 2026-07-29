package br.com.danielssaugusto.service;

import br.com.danielssaugusto.entity.CoupleMember;
import br.com.danielssaugusto.entity.User;
import br.com.danielssaugusto.repository.CoupleMemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class CoupleMemberService {
    CoupleMemberRepository coupleMemberRepository;
    CoupleMember coupleMember;

    @Transactional
    public CoupleMember signUpNewCoupleMember(CoupleMember coupleMember) {

        if (coupleMemberRepository.existsByEmail(coupleMember.getEmail())) {
            throw new IllegalArgumentException("User already exists.");
        }

        return coupleMemberRepository.save(coupleMember);
    }

    public User singInCoupleMember(CoupleMember coupleMember) {
        if (!coupleMemberRepository.existsByEmail(coupleMember.getEmail())) {
            throw new IllegalArgumentException("User not found.");
        }
        return coupleMember;
    }

    @Transactional
    public CoupleMember updateCoupleMemberEmail(UUID id, String email) {

        CoupleMember member = coupleMemberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Couple member not found."));

        member.setEmail(email);

        return coupleMemberRepository.save(member);
    }

    @Transactional
    public CoupleMember updateCoupleMemberPassword(UUID id, String password) {
        coupleMember = coupleMemberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Couple member not found"));

        coupleMember.setPassword(password);

        return coupleMemberRepository.save(coupleMember);
    }
}

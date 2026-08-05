package br.com.danielssaugusto.service;

import br.com.danielssaugusto.entity.CoupleMember;
import br.com.danielssaugusto.entity.User;
import br.com.danielssaugusto.repository.CoupleMemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class CoupleMemberService {
    CoupleMember coupleMember;
    CoupleMemberRepository coupleMemberRepository;

    private final List<CoupleMember> dbCoupleMember = new ArrayList<>();

    public CoupleMemberService() {
        dbCoupleMember.add(new CoupleMember("Jhon Doe", "jhondoe@email.com", "Abc12345@"));
    }

    public List<CoupleMember> findAll() { return dbCoupleMember; }

    public Stream<CoupleMember> findById(UUID id) {
        return dbCoupleMember.stream().filter(e -> e.getId().equals(id));
    }

    public CoupleMember save(CoupleMember coupleMember) {
        dbCoupleMember.add(coupleMember);
        return coupleMember;
    }

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

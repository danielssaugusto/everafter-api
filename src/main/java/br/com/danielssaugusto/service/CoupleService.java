package br.com.danielssaugusto.service;

import br.com.danielssaugusto.entity.Couple;
import br.com.danielssaugusto.entity.CoupleMember;
import br.com.danielssaugusto.repository.CoupleMemberRepository;
import br.com.danielssaugusto.repository.CoupleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class CoupleService {
    private final CoupleMemberRepository coupleMemberRepository;
    private final CoupleRepository coupleRepository;

    public CoupleService(CoupleMemberRepository coupleMemberRepository, CoupleRepository coupleRepository) {
        this.coupleMemberRepository = coupleMemberRepository;
        this.coupleRepository = coupleRepository;
    }

    public Couple createCouple(CoupleMember groom, CoupleMember bride) {
        Couple couple = new Couple(groom, bride);
        return coupleRepository.save(couple);
    }

    @Transactional
    public CoupleMember updateCoupleMemberEmail(UUID id, String email) {
        CoupleMember coupleMember = coupleMemberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Couple member not found."));

        coupleMember.setEmail(email);

        return coupleMember;
    }

}

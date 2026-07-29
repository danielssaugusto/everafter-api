package br.com.danielssaugusto.service;

import br.com.danielssaugusto.entity.Couple;
import br.com.danielssaugusto.entity.CoupleMember;
import br.com.danielssaugusto.repository.CoupleMemberRepository;
import br.com.danielssaugusto.repository.CoupleRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CoupleService {
    private final CoupleRepository coupleRepository;
    private final CoupleMemberRepository coupleMemberRepository;


    public CoupleService(CoupleRepository coupleRepository, CoupleMemberRepository coupleMemberRepository) {
        this.coupleRepository = coupleRepository;
        this.coupleMemberRepository = coupleMemberRepository;
    }

    public Couple createCouple(CoupleMember groom, CoupleMember bride) {
        Couple couple = new Couple(groom, bride);
        return coupleRepository.save(couple);
    }
}

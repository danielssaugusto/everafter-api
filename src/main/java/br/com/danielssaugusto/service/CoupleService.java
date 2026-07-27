package br.com.danielssaugusto.service;

import br.com.danielssaugusto.entity.Couple;
import br.com.danielssaugusto.entity.CoupleMember;
import br.com.danielssaugusto.repository.CoupleRepository;

import static jakarta.persistence.GenerationType.UUID;

public class CoupleService {
    private final CoupleRepository coupleRepository;

    public CoupleService(CoupleRepository coupleRepository) {
        this.coupleRepository = coupleRepository;
    }

    public Couple createCouple(CoupleMember groom, CoupleMember bride) {
        Couple couple = new Couple(groom, bride);
        return coupleRepository.save(couple);
    }
}

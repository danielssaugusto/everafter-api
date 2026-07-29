package br.com.danielsaugusto.service;

import br.com.danielssaugusto.entity.Couple;
import br.com.danielssaugusto.entity.CoupleMember;
import br.com.danielssaugusto.repository.CoupleMemberRepository;
import br.com.danielssaugusto.repository.CoupleRepository;
import br.com.danielssaugusto.service.CoupleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class CoupleServiceTest {

    private CoupleService coupleService;

    @Mock
    private CoupleRepository coupleRepository;

    @Mock
    private CoupleMemberRepository coupleMemberRepository;

    private CoupleMember groom;
    private CoupleMember bride;

    @BeforeEach
    void setup() {

        coupleService = new CoupleService(
                coupleRepository,
                coupleMemberRepository
        );

        groom = new CoupleMember("...", "...", "...");
        bride = new CoupleMember("...", "...", "...");
    }

    @Test
    void should_create_couple_with_groom_and_bride() {

        when(coupleRepository.save(any(Couple.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        Couple couple = coupleService.createCouple(groom, bride);

        Assertions.assertNotNull(couple);
        Assertions.assertEquals(groom, couple.getGroom());
        Assertions.assertEquals(bride, couple.getBride());

        verify(coupleRepository).save(any(Couple.class));
    }
}
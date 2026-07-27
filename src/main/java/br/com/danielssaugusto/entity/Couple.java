package br.com.danielssaugusto.entity;

import jakarta.persistence.GeneratedValue;
import org.springframework.data.annotation.Id;

import java.util.UUID;

public class Couple {
    @Id
    @GeneratedValue
    private UUID id;
    private CoupleMember groom;
    private CoupleMember bride;

    protected Couple() {}

    public Couple(CoupleMember groom, CoupleMember bride) {
        this.groom = groom;
        this.bride = bride;
    }

}

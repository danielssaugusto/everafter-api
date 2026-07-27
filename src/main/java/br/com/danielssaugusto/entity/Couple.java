package br.com.danielssaugusto.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.util.UUID;

@Entity
public class Couple {
    @Id
    @GeneratedValue
    private UUID id;
    @OneToOne
    private CoupleMember groom;
    @OneToOne
    private CoupleMember bride;

    protected Couple() {}

    public Couple(CoupleMember groom, CoupleMember bride) {
        this.groom = groom;
        this.bride = bride;
    }

}

package br.com.danielssaugusto.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CoupleMember extends User{

    CoupleMember coupleMemberRepository;

    public CoupleMember(String name, String email, String password) {
        super(name, email, password);
    }
}

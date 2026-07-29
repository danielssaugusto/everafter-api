package br.com.danielssaugusto.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoupleMember extends User{

    public CoupleMember(String name, String email, String password) {
        super(name, email, password);
    }
}

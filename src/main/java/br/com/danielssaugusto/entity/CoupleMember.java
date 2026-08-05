package br.com.danielssaugusto.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CoupleMember extends User{

    public CoupleMember(String name, String email, String password) {
        super(name, email, password);
    }
}

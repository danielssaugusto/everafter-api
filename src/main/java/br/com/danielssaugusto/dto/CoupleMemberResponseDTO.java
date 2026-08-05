package br.com.danielssaugusto.dto;

import br.com.danielssaugusto.entity.CoupleMember;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CoupleMemberResponseDTO {
    private UUID id;
    private String name;
    private String email;
    private String password;


    public CoupleMemberResponseDTO(CoupleMember coupleMember) {
        this.id = coupleMember.getId();
        this.name = coupleMember.getName();
        this.email = coupleMember.getEmail();
        this.password = coupleMember.getPassword();
    }
}

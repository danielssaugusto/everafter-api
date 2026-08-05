package br.com.danielssaugusto.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoupleMemberRequestDTO {
    private String name;
    private String email;
    private String password;
}

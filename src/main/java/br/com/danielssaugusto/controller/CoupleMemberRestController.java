package br.com.danielssaugusto.controller;

import br.com.danielssaugusto.dto.CoupleMemberResponseDTO;
import br.com.danielssaugusto.entity.Couple;
import br.com.danielssaugusto.entity.CoupleMember;
import br.com.danielssaugusto.repository.CoupleMemberRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CountedCompleter;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/couple-member")
public class CoupleMemberRestController {
    private final CoupleMemberRepository coupleMemberRepository;

    public CoupleMemberRestController(CoupleMemberRepository coupleMemberRepository) {
        this.coupleMemberRepository = coupleMemberRepository;
    }

    @GetMapping
    public List<CoupleMemberResponseDTO> listar() {
        return coupleMemberRepository.findAll().stream().map(CoupleMemberResponseDTO::new).collect(Collectors.toList());
    }
}

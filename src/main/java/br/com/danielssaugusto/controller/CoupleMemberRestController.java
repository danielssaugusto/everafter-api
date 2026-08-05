package br.com.danielssaugusto.controller;

import br.com.danielssaugusto.dto.CoupleMemberRequestDTO;
import br.com.danielssaugusto.dto.CoupleMemberResponseDTO;
import br.com.danielssaugusto.entity.Couple;
import br.com.danielssaugusto.entity.CoupleMember;
import br.com.danielssaugusto.repository.CoupleMemberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/protect")
    public ResponseEntity<CoupleMemberResponseDTO> createWitchProtect(@RequestBody CoupleMemberRequestDTO dto) {
        CoupleMember newMember = new CoupleMember(
                dto.getName(),
                dto.getEmail(),
                dto.getPassword()
        );
        CoupleMember saved = coupleMemberRepository.save(newMember);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CoupleMemberResponseDTO(saved));
    }
}

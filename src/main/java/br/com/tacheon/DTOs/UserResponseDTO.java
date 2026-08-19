package br.com.tacheon.DTOs;

import java.util.UUID;

public record UserResponseDTO(
        UUID id,
        String username,
        String email,
        String phone
) {
}

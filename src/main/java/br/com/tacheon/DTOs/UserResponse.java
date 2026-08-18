package br.com.tacheon.DTOs;

import java.util.UUID;

public record UserResponse(
        UUID id,
        String username,
        String email,
        String phone
) {
}

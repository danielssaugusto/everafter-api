package br.com.tacheon.DTOs;

public record UserRequestDTO(
        String username,
        String email,
        String phone,
        String password)
{
}
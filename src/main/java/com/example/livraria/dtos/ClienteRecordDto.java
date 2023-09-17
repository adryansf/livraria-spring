package com.example.livraria.dtos;

import jakarta.validation.constraints.NotBlank;

public record ClienteRecordDto(@NotBlank String nome, @NotBlank String cpf, @NotBlank String contato,
    @NotBlank String generoFavorito, @NotBlank String autorFavorito) {
}
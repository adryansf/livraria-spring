package com.example.livraria.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LivroRecordDto(@NotBlank String nome, @NotNull Double valor, @NotBlank String genero,
        @NotBlank String autor, @NotBlank String editora, @NotNull int anoPublicacao) {
}
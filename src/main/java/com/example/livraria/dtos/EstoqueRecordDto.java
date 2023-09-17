package com.example.livraria.dtos;

import jakarta.validation.constraints.NotNull;

public record EstoqueRecordDto(@NotNull int quantidade) {
}
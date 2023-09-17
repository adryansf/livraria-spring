package com.example.livraria.dtos;

import jakarta.validation.constraints.NotNull;

public record ItemRecordDto(@NotNull int idPedido, @NotNull int idLivro, @NotNull int quantidade) {

}
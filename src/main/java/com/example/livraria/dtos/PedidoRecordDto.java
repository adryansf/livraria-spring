package com.example.livraria.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PedidoRecordDto(@NotNull int idCliente, @NotBlank String codigoVendedor) {

}
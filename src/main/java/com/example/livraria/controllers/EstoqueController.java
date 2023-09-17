package com.example.livraria.controllers;

import com.example.livraria.dtos.EstoqueRecordDto;
import com.example.livraria.models.EstoqueModel;
import com.example.livraria.services.EstoqueService;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Estoques")
@RestController
@RequestMapping("/estoques")
public class EstoqueController {
  @Autowired
  EstoqueService estoqueService;

  @PostMapping("{id}/entrada")
  ResponseEntity<EstoqueModel> entradaEstoque(@PathParam("id") int idEstoque,
      @RequestBody @Valid EstoqueRecordDto novoEstoqueDto) {
    EstoqueModel estoque = estoqueService.entradaEstoque(idEstoque, novoEstoqueDto);
    return ResponseEntity.ok().body(estoque);
  }

  @PostMapping("{id}/baixa")
  ResponseEntity<EstoqueModel> baixaEstoque(@PathParam("id") int idEstoque,
      @RequestBody @Valid EstoqueRecordDto novoEstoqueDto) {
    EstoqueModel estoque = estoqueService.baixaEstoque(idEstoque, novoEstoqueDto);
    return ResponseEntity.ok().body(estoque);
  }
}

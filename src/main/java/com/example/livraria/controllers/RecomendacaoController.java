package com.example.livraria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.livraria.models.LivroModel;
import com.example.livraria.services.RecomendacaoService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Recomendacoes")
@RestController
@RequestMapping("/recomendacao")
public class RecomendacaoController {
  @Autowired
  RecomendacaoService recomendacaoService;

  @GetMapping("{idCliente}/porAutor")
  public ResponseEntity<List<LivroModel>> recomendacaoPorAutor(@PathVariable("idCliente") int idCliente) {
    List<LivroModel> recomendacoes = recomendacaoService.recomendar(idCliente, "PorAutor");
    return ResponseEntity.ok().body(recomendacoes);
  }

  @GetMapping("{idCliente}/porGenero")
  public ResponseEntity<List<LivroModel>> recomendacaoPorGenero(@PathVariable("idCliente") int idCliente) {
    List<LivroModel> recomendacoes = recomendacaoService.recomendar(idCliente, "PorGenero");
    return ResponseEntity.ok().body(recomendacoes);
  }
}

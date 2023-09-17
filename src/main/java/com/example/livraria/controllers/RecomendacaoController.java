package com.example.livraria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.livraria.models.LivroModel;
import com.example.livraria.services.RecomendacaoService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/recomendacao")
public class RecomendacaoController {
  @Autowired
  RecomendacaoService recomendacaoService;

  @GetMapping("{idCliente}")
  public ResponseEntity<List<LivroModel>> recomendacaoPorAutor(@PathParam("idCliente") int idCliente) {
    List<LivroModel> recomendacoes = recomendacaoService.recomendacaoPorAutor(idCliente);
    return ResponseEntity.ok().body(recomendacoes);
  }
}

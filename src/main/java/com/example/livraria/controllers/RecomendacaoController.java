package com.example.livraria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.livraria.models.LivroModel;
import com.example.livraria.services.RecomendacaoService;
import com.example.livraria.strategy.RecomendacaoPorAutorStrategy;
import com.example.livraria.strategy.RecomendacaoPorGeneroStrategy;
import com.example.livraria.strategy.RecomendacaoStrategy;

import jakarta.websocket.server.PathParam;

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

// @RestController
// @RequestMapping("/recomendacao")
// public class RecomendacaoController {
// @Autowired
// RecomendacaoService recomendacaoService;

// // private final RecomendacaoService recomendacaoService;
// private final RecomendacaoStrategy recomendacaoStrategy;

// @Autowired
// public RecomendacaoController(RecomendacaoService recomendacaoService,
// RecomendacaoStrategy recomendacaoStrategy) {
// this.recomendacaoService = recomendacaoService;
// this.recomendacaoStrategy = recomendacaoStrategy;
// }

// // @GetMapping("{idCliente}/porAutor")
// // public ResponseEntity<List<LivroModel>>
// // recomendacaoPorAutor(@PathVariable("idCliente") int idCliente,
// // @Qualifier("recomendacaoPorAutorStrategy") RecomendacaoStrategy strategy)
// {
// // recomendacaoService.setRecomendacaoStrategy(strategy);
// // List<LivroModel> recomendacoes =
// recomendacaoService.recomendar(idCliente);
// // return ResponseEntity.ok().body(recomendacoes);
// // }

// // @GetMapping("{idCliente}/porGenero")
// // public ResponseEntity<List<LivroModel>>
// // recomendacaoPorGenero(@PathVariable("idCliente") int idCliente,
// // @Qualifier("recomendacaoPorGeneroStrategy") RecomendacaoStrategy strategy)
// {
// // recomendacaoService.setRecomendacaoStrategy(strategy);
// // List<LivroModel> recomendacoes =
// recomendacaoService.recomendar(idCliente);
// // return ResponseEntity.ok().body(recomendacoes);
// // }

// @GetMapping("{idCliente}/porAutor")
// public ResponseEntity<List<LivroModel>>
// recomendacaoPorAutor(@PathVariable("idCliente") int idCliente) {
// recomendacaoService.setRecomendacaoStrategy(recomendacaoStrategy);
// List<LivroModel> recomendacoes = recomendacaoService.recomendar(idCliente);
// return ResponseEntity.ok().body(recomendacoes);
// }

// @GetMapping("{idCliente}/porGenero")
// public ResponseEntity<List<LivroModel>>
// recomendacaoPorGenero(@PathVariable("idCliente") int idCliente) {
// recomendacaoService.setRecomendacaoStrategy(recomendacaoStrategy);
// List<LivroModel> recomendacoes = recomendacaoService.recomendar(idCliente);
// return ResponseEntity.ok().body(recomendacoes);
// }

// // @GetMapping("{idCliente}")
// // public ResponseEntity<List<LivroModel>>
// // recomendacaoPorAutor(@PathParam("idCliente") int idCliente) {
// // List<LivroModel> recomendacoes =
// // recomendacaoService.recomendacaoPorAutor(idCliente);
// // return ResponseEntity.ok().body(recomendacoes);
// // }

// // @GetMapping("{idCliente}/porAutor")
// // public ResponseEntity<List<LivroModel>>
// // recomendacaoPorAutor(@PathVariable("idCliente") int idCliente) {
// // recomendacaoService.setRecomendacaoStrategy(new
// // RecomendacaoPorAutorStrategy());
// // List<LivroModel> recomendacoes =
// recomendacaoService.recomendar(idCliente);
// // return ResponseEntity.ok().body(recomendacoes);
// // }

// // @GetMapping("{idCliente}/porGenero")
// // public ResponseEntity<List<LivroModel>>
// // recomendacaoPorGenero(@PathVariable("idCliente") int idCliente) {
// // recomendacaoService.setRecomendacaoStrategy(new
// // RecomendacaoPorGeneroStrategy());
// // List<LivroModel> recomendacoes =
// recomendacaoService.recomendar(idCliente);
// // return ResponseEntity.ok().body(recomendacoes);
// // }
// }

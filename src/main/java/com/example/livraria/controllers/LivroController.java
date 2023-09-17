package com.example.livraria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

import com.example.livraria.dtos.LivroRecordDto;
import com.example.livraria.models.LivroModel;
import com.example.livraria.services.LivroService;

@Tag(name = "Livros")
@RequestMapping("/livros")
@RestController
public class LivroController {
  @Autowired
  LivroService livroService;

  @GetMapping
  ResponseEntity<List<LivroModel>> obterLivros() {
    List<LivroModel> livros = livroService.obterLivros();
    return ResponseEntity.ok().body(livros);
  }

  @GetMapping("{id}")
  ResponseEntity<LivroModel> obterLivro(@PathParam("id") int idLivro) {
    LivroModel livro = livroService.obterLivro(idLivro);
    return ResponseEntity.ok().body(livro);
  }

  @PostMapping
  ResponseEntity<LivroModel> cadastrarLivro(@RequestBody @Valid LivroRecordDto novoLivroDto) {
    LivroModel livro = livroService.cadastrarLivro(novoLivroDto);
    return ResponseEntity.ok().body(livro);
  }

  @DeleteMapping("{id}")
  @ResponseStatus(value = HttpStatus.NO_CONTENT)
  void deletarLivro(@PathParam("id") int idLivro) {
    livroService.deletarLivro(idLivro);
  }
}

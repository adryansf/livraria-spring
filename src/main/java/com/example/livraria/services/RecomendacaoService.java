package com.example.livraria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.livraria.models.LivroModel;
import com.example.livraria.repositories.ClienteRepository;
import com.example.livraria.repositories.LivroRepository;
import com.example.livraria.strategy.RecomendacaoPorAutorStrategy;
import com.example.livraria.strategy.RecomendacaoPorGeneroStrategy;
import com.example.livraria.strategy.RecomendacaoStrategy;

@Service
public class RecomendacaoService {
  @Autowired
  ClienteRepository clienteRepository;

  @Autowired
  LivroRepository livroRepository;

  @Autowired
  RecomendacaoPorAutorStrategy autorStrategy;

  @Autowired
  RecomendacaoPorGeneroStrategy generoStrategy;

  RecomendacaoStrategy strategy;

  public List<LivroModel> recomendar(int idCliente, String estrategia) {

    if ("PorAutor".equals(estrategia)) {
      this.strategy = autorStrategy;
    } else if ("PorGenero".equals(estrategia)) {
      this.strategy = generoStrategy;
    } else {
      throw new IllegalArgumentException("Estratégia de recomendação inválida: " + estrategia);
    }
    return this.strategy.recomendar(idCliente);
  }
}

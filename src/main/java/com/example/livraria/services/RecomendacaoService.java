package com.example.livraria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.livraria.exception.NotFoundException;
import com.example.livraria.models.ClienteModel;
import com.example.livraria.models.LivroModel;
import com.example.livraria.repositories.ClienteRepository;
import com.example.livraria.repositories.LivroRepository;
import com.example.livraria.strategy.RecomendacaoStrategy;

@Service
public class RecomendacaoService {
  @Autowired
  ClienteRepository clienteRepository;

  @Autowired
  LivroRepository livroRepository;

  // public List<LivroModel> recomendacaoPorAutor(int idCliente) {
  // ClienteModel cliente = clienteRepository.findById(idCliente)
  // .orElseThrow(() -> new NotFoundException("Cliente não encontrado!"));

  // List<LivroModel> livros = livroRepository.findAll();

  // return livros;
  // }

  // @Autowired
  // private RecomendacaoStrategy recomendacaoStrategy;

  // // Método para definir a estratégia com base em algum critério
  // public void setRecomendacaoStrategy(RecomendacaoStrategy
  // recomendacaoStrategy) {
  // this.recomendacaoStrategy = recomendacaoStrategy;
  // }

  // public List<LivroModel> recomendar(int idCliente) {
  // return recomendacaoStrategy.recomendar(idCliente);
  // }

  public List<LivroModel> recomendar(int idCliente, String estrategia) {
    ClienteModel cliente = clienteRepository.findById(idCliente)
        .orElseThrow(() -> new NotFoundException("Cliente não encontrado!"));

    if ("PorAutor".equals(estrategia)) {
      String autorFavorito = cliente.getAutorFavorito();
      return livroRepository.findByAutor(autorFavorito);
    } else if ("PorGenero".equals(estrategia)) {
      String generoFavorito = cliente.getGeneroFavorito();
      return livroRepository.findByGenero(generoFavorito);
    } else {
      throw new IllegalArgumentException("Estratégia de recomendação inválida: " + estrategia);
    }
  }

}

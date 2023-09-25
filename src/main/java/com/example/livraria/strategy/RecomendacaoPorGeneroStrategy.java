package com.example.livraria.strategy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.livraria.exception.NotFoundException;
import com.example.livraria.models.ClienteModel;
import com.example.livraria.models.LivroModel;
import com.example.livraria.repositories.ClienteRepository;
import com.example.livraria.repositories.LivroRepository;

@Component
public class RecomendacaoPorGeneroStrategy implements RecomendacaoStrategy {
  @Autowired
  private ClienteRepository clienteRepository;

  @Autowired
  private LivroRepository livroRepository;

  @Override
  public List<LivroModel> recomendar(int idCliente) {
    ClienteModel cliente = clienteRepository.findById(idCliente)
        .orElseThrow(() -> new NotFoundException("Cliente não encontrado!"));

    String generoFavorito = cliente.getGeneroFavorito();
    return livroRepository.findByGenero(generoFavorito);
  }
}

package com.example.livraria.strategy;

import java.util.List;

import com.example.livraria.models.LivroModel;

public interface RecomendacaoStrategy {
  List<LivroModel> recomendar(int idCliente);
}

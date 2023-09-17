package com.example.livraria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.livraria.dtos.EstoqueRecordDto;
import com.example.livraria.exception.NotFoundException;
import com.example.livraria.models.EstoqueModel;
import com.example.livraria.repositories.EstoqueRepository;

@Service
public class EstoqueService {
  @Autowired
  EstoqueRepository estoqueRepository;

  public EstoqueModel entradaEstoque(int idEstoque, EstoqueRecordDto estoqueNovo) {
    EstoqueModel estoque = estoqueRepository.findById(idEstoque)
        .orElseThrow(() -> new NotFoundException("Estoque não encontrado!"));
    estoque.setQuantidade(estoque.getQuantidade() + estoqueNovo.quantidade());
    estoqueRepository.save(estoque);
    return estoque;
  }

  public EstoqueModel baixaEstoque(int idEstoque, EstoqueRecordDto estoqueNovo) {
    EstoqueModel estoque = estoqueRepository.findById(idEstoque)
        .orElseThrow(() -> new NotFoundException("Estoque não encontrado!"));
    estoque.setQuantidade(estoque.getQuantidade() - estoqueNovo.quantidade());
    estoqueRepository.save(estoque);
    return estoque;
  }
}

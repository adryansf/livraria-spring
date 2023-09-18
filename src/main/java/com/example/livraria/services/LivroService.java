package com.example.livraria.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.livraria.dtos.LivroRecordDto;
import com.example.livraria.exception.NotFoundException;
import com.example.livraria.models.EstoqueModel;
import com.example.livraria.models.LivroModel;
import com.example.livraria.repositories.EstoqueRepository;
import com.example.livraria.repositories.LivroRepository;

import java.util.List;

@Service
public class LivroService {
  @Autowired
  LivroRepository livroRepository;

  @Autowired
  EstoqueRepository estoqueRepository;

  public List<LivroModel> obterLivros() {
    return livroRepository.findAll();
  }

  public LivroModel obterLivro(int idLivro) {
    return livroRepository.findById(idLivro).orElseThrow(() -> new NotFoundException("Livro não encontrado!"));
  }

  public LivroModel cadastrarLivro(LivroRecordDto novoLivroDto) {
    LivroModel livro = new LivroModel();
    BeanUtils.copyProperties(novoLivroDto, livro);

    EstoqueModel estoque = new EstoqueModel();

    livroRepository.save(livro);

    estoque.setLivro(livro);
    estoqueRepository.save(estoque);

    return livro;
  }

  public void deletarLivro(int idLivro) {
    livroRepository.deleteById(idLivro);
  }
}

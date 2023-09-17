package com.example.livraria.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.livraria.dtos.LivroRecordDto;
import com.example.livraria.exception.NotFoundException;
import com.example.livraria.models.LivroModel;
import com.example.livraria.repositories.LivroRepository;

import java.util.List;

@Service
public class LivroService {
  @Autowired
  LivroRepository livroRepository;

  public List<LivroModel> obterLivros() {
    return livroRepository.findAll();
  }

  public LivroModel obterLivro(int idLivro) {
    return livroRepository.findById(idLivro).orElseThrow(() -> new NotFoundException("Livro não encontrado!"));
  }

  public LivroModel cadastrarLivro(LivroRecordDto novoLivroDto) {
    LivroModel livro = new LivroModel();
    BeanUtils.copyProperties(novoLivroDto, livro);
    livroRepository.save(livro);
    return livro;
  }

  public void deletarLivro(int idLivro) {
    livroRepository.deleteById(idLivro);
  }
}

package com.example.livraria.database;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.livraria.models.ClienteModel;
import com.example.livraria.models.LivroModel;
import com.example.livraria.repositories.ClienteRepository;
import com.example.livraria.repositories.LivroRepository;

// @RestController
public class Seed {
  // @Autowired
  ClienteRepository clienteRepository;

  // @Autowired
  LivroRepository livroRepository;

  // @GetMapping("/seed")
  public void run() {
    ClienteModel cliente1 = new ClienteModel();
    cliente1.setNome("Jane Doe");
    cliente1.setCpf("891.637.780-33");
    cliente1.setContato("22981334571");
    cliente1.setGeneroFavorito("Ficção Científica");
    cliente1.setAutorFavorito("Machado de Assis");

    clienteRepository.save(cliente1);

    ArrayList<LivroModel> livros = new ArrayList<LivroModel>();
    LivroModel livro1 = new LivroModel();
    livro1.setNome("Orgulho e Preconceito");
    livro1.setGenero("Romance");
    livro1.setValor(19.99);
    livro1.setAutor("Jane Austen");
    livro1.setEditora("Editora A");
    livro1.setAnoPublicacao(1995);
    livros.add(livro1);

    LivroModel livro2 = new LivroModel();
    livro2.setNome("O Senhor dos Anéis");
    livro2.setGenero("Fantasia");
    livro2.setValor(49.99);
    livro2.setAutor("J.R.R. Tolkien");
    livro2.setEditora("Editora XYZ");
    livro2.setAnoPublicacao(2001);
    livros.add(livro2);

    LivroModel livro3 = new LivroModel();
    livro3.setNome("1984");
    livro3.setGenero("Ficção Científica");
    livro3.setValor(29.99);
    livro3.setAutor("George Orwell");
    livro3.setEditora("Editora ABC");
    livro3.setAnoPublicacao(1949);
    livros.add(livro3);

    LivroModel livro4 = new LivroModel();
    livro4.setNome("Dom Quixote");
    livro4.setGenero("Clássico");
    livro4.setValor(19.99);
    livro4.setAutor("Miguel de Cervantes");
    livro4.setEditora("Editora DEF");
    livro4.setAnoPublicacao(1605);
    livros.add(livro4);

    LivroModel livro5 = new LivroModel();
    livro5.setNome("Crepúsculo");
    livro5.setGenero("Romance");
    livro5.setValor(19.99);
    livro5.setAutor("Stephenie Meyer");
    livro5.setEditora("Editora QRS");
    livro5.setAnoPublicacao(2005);
    livros.add(livro5);

    livros.forEach(l -> livroRepository.save(l));
  }
}

package com.example.livraria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.livraria.models.LivroModel;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface LivroRepository extends JpaRepository<LivroModel, Integer> {
  @Query("SELECT l FROM LivroModel l WHERE l.autor = :autor")
  List<LivroModel> findByAutor(String autor);

  @Query("SELECT l FROM LivroModel l WHERE l.genero = :genero")
  List<LivroModel> findByGenero(String genero);
}

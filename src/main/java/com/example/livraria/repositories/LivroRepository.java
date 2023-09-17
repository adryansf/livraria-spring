package com.example.livraria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.livraria.models.LivroModel;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface LivroRepository extends JpaRepository<LivroModel, Integer> {

}

package com.example.livraria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.livraria.models.EstoqueModel;

import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface EstoqueRepository extends JpaRepository<EstoqueModel, Integer> {

}

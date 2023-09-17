package com.example.livraria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.livraria.models.ItemModel;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface ItemRepository extends JpaRepository<ItemModel, Integer> {

}

package com.example.livraria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;


import com.example.livraria.dtos.ItemRecordDto;
import com.example.livraria.models.ItemModel;
import com.example.livraria.services.ItemService;

@Tag(name = "Itens")
@RequestMapping("/itens")
@RestController
public class ItemController {
  @Autowired
  ItemService itemService;

  @PostMapping
  ResponseEntity<ItemModel> adicionarItem(@RequestBody @Valid ItemRecordDto novoItemDto) {
    ItemModel item = itemService.adicionarItem(novoItemDto);
    return ResponseEntity.ok().body(item);
  }

  @PostMapping("{id}")
  ResponseEntity<ItemModel> removerItem(@PathVariable("id") int idItem) {
    ItemModel item = itemService.removerItem(idItem);
    return ResponseEntity.ok().body(item);
  }
}

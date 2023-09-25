package com.example.livraria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.livraria.dtos.PedidoRecordDto;
import com.example.livraria.models.PedidoModel;
import com.example.livraria.services.PedidoService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;


@Tag(name = "Pedidos")
@RestController
@RequestMapping("/pedidos")
public class PedidoController {
  @Autowired
  PedidoService pedidoService;

  @GetMapping("{id}")
  public ResponseEntity<PedidoModel> obterPedido(@PathVariable("id") int idPedido) {
    PedidoModel pedido = pedidoService.obterPedido(idPedido);
    return ResponseEntity.ok().body(pedido);
  }

  @PostMapping
  public ResponseEntity<PedidoModel> iniciarPedido(@RequestBody @Valid PedidoRecordDto novoPedido) {
    PedidoModel pedido = pedidoService.iniciarPedido(novoPedido);
    return ResponseEntity.ok().body(pedido);
  }

  @PostMapping("{id}")
  public ResponseEntity<PedidoModel> finalizarPedido(@PathVariable("id") int idPedido) {
    PedidoModel pedido = pedidoService.finalizarPedido(idPedido);
    return ResponseEntity.ok().body(pedido);
  }
}

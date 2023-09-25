package com.example.livraria.controllers;

import com.example.livraria.dtos.ClienteRecordDto;
import com.example.livraria.models.ClienteModel;
import com.example.livraria.services.ClienteService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Clientes")
@RestController
@RequestMapping("/clientes")
public class ClienteController {
  @Autowired
  ClienteService clienteService;

  @GetMapping
  ResponseEntity<List<ClienteModel>> obterClientes() {
    List<ClienteModel> clientes = clienteService.obterClientes();
    return ResponseEntity.ok().body(clientes);
  }

  @GetMapping("{id}")
  ResponseEntity<ClienteModel> obterCliente(@PathVariable("id") int idCliente) {
    ClienteModel cliente = clienteService.obterCliente(idCliente);
    return ResponseEntity.ok().body(cliente);
  }

  @PostMapping
  ResponseEntity<ClienteModel> cadastrarCliente(@RequestBody @Valid ClienteRecordDto novoClienteDto) {
    ClienteModel cliente = clienteService.cadastrarCliente(novoClienteDto);
    return ResponseEntity.ok().body(cliente);
  }

  @PatchMapping("{id}")
  ResponseEntity<ClienteModel> atualizarCliente(@PathVariable("id") int idCliente,
      @RequestBody @Valid ClienteRecordDto clienteAtualizadoDto) {
    ClienteModel cliente = clienteService.atualizarCliente(idCliente, clienteAtualizadoDto);
    return ResponseEntity.ok().body(cliente);
  }
}

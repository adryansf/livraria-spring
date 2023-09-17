package com.example.livraria.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.livraria.dtos.ClienteRecordDto;
import com.example.livraria.exception.NotFoundException;
import com.example.livraria.models.ClienteModel;
import com.example.livraria.repositories.ClienteRepository;

import java.util.List;

@Service
public class ClienteService {
  @Autowired
  ClienteRepository clienteRepository;

  public List<ClienteModel> obterClientes() {
    return clienteRepository.findAll();
  }

  public ClienteModel obterCliente(int idCliente) {
    return clienteRepository.findById(idCliente)
        .orElseThrow(() -> new NotFoundException("Cliente não encontrado!"));
  }

  public ClienteModel cadastrarCliente(ClienteRecordDto novoClienteDto) {
    ClienteModel cliente = new ClienteModel();
    BeanUtils.copyProperties(novoClienteDto, cliente);
    clienteRepository.save(cliente);
    return cliente;
  }

  public ClienteModel atualizarCliente(int idCliente, ClienteRecordDto clienteAtualizadoDto) {
    ClienteModel cliente = clienteRepository.findById(idCliente)
        .orElseThrow(() -> new NotFoundException("Cliente não encontrado!"));
    BeanUtils.copyProperties(clienteAtualizadoDto, cliente);
    clienteRepository.save(cliente);
    return cliente;
  }
}

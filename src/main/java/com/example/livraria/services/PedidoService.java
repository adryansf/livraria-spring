package com.example.livraria.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.livraria.dtos.PedidoRecordDto;
import com.example.livraria.enums.SituacaoPedidoEnum;
import com.example.livraria.exception.InvalidOperationException;
import com.example.livraria.exception.NotFoundException;
import com.example.livraria.models.ClienteModel;
import com.example.livraria.models.EstoqueModel;
import com.example.livraria.models.ItemModel;
import com.example.livraria.models.PedidoModel;
import com.example.livraria.repositories.ClienteRepository;
import com.example.livraria.repositories.EstoqueRepository;
import com.example.livraria.repositories.PedidoRepository;

@Service
public class PedidoService {
  @Autowired
  PedidoRepository pedidoRepository;

  @Autowired
  ClienteRepository clienteRepository;

  @Autowired
  EstoqueRepository estoqueRepository;

  public PedidoModel obterPedido(int idPedido) {
    return pedidoRepository.findById(idPedido)
        .orElseThrow(() -> new NotFoundException("Pedido não encontrado!"));
  }

  public void obterItens(int idPedido) {
    PedidoModel pedido = pedidoRepository.findById(idPedido)
        .orElseThrow(() -> new NotFoundException("Pedido não encontrado!"));

        pedido.getItens();
  }

  public PedidoModel iniciarPedido(PedidoRecordDto novoPedido) {
    int idCliente = novoPedido.idCliente();

    ClienteModel cliente = clienteRepository.findById(idCliente)
        .orElseThrow(() -> new NotFoundException("Cliente não encontrado!"));

    Set<PedidoModel> pedidos = cliente.getPedidos();
    if (!pedidos.isEmpty())
      throw new InvalidOperationException("Você já possui um pedido aberto");

    PedidoModel pedido = new PedidoModel();
    pedido.setCodigoVendedor(novoPedido.codigoVendedor());
    pedido.setSituacao(SituacaoPedidoEnum.ABERTO);
    pedido.setTotal(0.00);
    pedido.setCliente(cliente);
    pedidoRepository.save(pedido);
    return pedido;
  }

  public PedidoModel finalizarPedido(int idPedido) {
    PedidoModel pedido = pedidoRepository.findById(idPedido)
        .orElseThrow(() -> new NotFoundException("Pedido não encontrado!"));

    pedido.setSituacao(SituacaoPedidoEnum.CONCLUÍDO);
    pedidoRepository.save(pedido);
    return pedido;
  }

  public PedidoModel cancelarPedido(int idPedido) {
    PedidoModel pedido = pedidoRepository.findById(idPedido)
        .orElseThrow(() -> new NotFoundException("Pedido não encontrado!"));

    for (ItemModel item : pedido.getItens()) {
      EstoqueModel estoque = estoqueRepository.findById(item.getLivro().getEstoque().getId())
          .orElseThrow(() -> new NotFoundException("Estoque não encontrado!"));
      estoque.setQuantidade(estoque.getQuantidade() + item.getQuantidade());
      estoqueRepository.save(estoque);
    }
    pedido.setSituacao(SituacaoPedidoEnum.CANCELADO);
    pedidoRepository.save(pedido);
    return pedido;
  }
}

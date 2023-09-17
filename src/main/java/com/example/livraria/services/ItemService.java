package com.example.livraria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.livraria.dtos.ItemRecordDto;
import com.example.livraria.exception.InvalidOperationException;
import com.example.livraria.exception.NotFoundException;
import com.example.livraria.models.EstoqueModel;
import com.example.livraria.models.ItemModel;
import com.example.livraria.models.LivroModel;
import com.example.livraria.models.PedidoModel;
import com.example.livraria.repositories.EstoqueRepository;
import com.example.livraria.repositories.ItemRepository;
import com.example.livraria.repositories.LivroRepository;
import com.example.livraria.repositories.PedidoRepository;

@Service
public class ItemService {
  @Autowired
  ItemRepository itemRepository;

  @Autowired
  PedidoRepository pedidoRepository;

  @Autowired
  LivroRepository livroRepository;

  @Autowired
  EstoqueRepository estoqueRepository;

  public ItemModel adicionarItem(ItemRecordDto itemNovo) {
    PedidoModel pedido = pedidoRepository.findById(itemNovo.idPedido())
        .orElseThrow(() -> new NotFoundException("Pedido não encontrado!"));

    LivroModel livro = livroRepository.findById(itemNovo.idLivro())
        .orElseThrow(() -> new NotFoundException("Livro não encontrado!"));

    ItemModel item = new ItemModel();
    EstoqueModel estoque = livro.getEstoque();
    int quantidadeItem = itemNovo.quantidade();
    int quantidadeEmEstoque = estoque.getQuantidade();
    if (quantidadeEmEstoque < quantidadeItem)
      throw new InvalidOperationException("Quantidade inválida.");
    estoque.setQuantidade(quantidadeEmEstoque - quantidadeItem);

    Double subtotal = livro.getValor() * quantidadeItem;
    item.setLivro(livro);
    item.setPedido(pedido);
    item.setQuantidade(quantidadeItem);
    item.setSubtotal(subtotal);

    pedido.setTotal(pedido.getTotal() + subtotal);

    estoqueRepository.save(estoque);
    pedidoRepository.save(pedido);
    itemRepository.save(item);

    return item;
  }

  public ItemModel removerItem(int idItem) {
    ItemModel item = itemRepository.findById(idItem)
        .orElseThrow(() -> new NotFoundException("Item não encontrado!"));

    EstoqueModel estoque = item.getLivro().getEstoque();
    PedidoModel pedido = item.getPedido();
    estoque.setQuantidade(item.getQuantidade() + estoque.getQuantidade());
    pedido.setTotal(pedido.getTotal() - item.getSubtotal());

    estoqueRepository.save(estoque);
    pedidoRepository.save(pedido);
    itemRepository.delete(item);

    return item;
  }
}

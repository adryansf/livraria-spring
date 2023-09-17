package com.example.livraria.models;

import com.example.livraria.enums.SituacaoPedidoEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "pedidos")
public class PedidoModel implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  private SituacaoPedidoEnum situacao;
  private Double total;
  private String codigoVendedor;

  @OneToMany(mappedBy = "pedido")
  private Set<ItemModel> itens;

  @ManyToOne
  @JoinColumn(name = "idCliente", nullable = false)
  private ClienteModel cliente;
}
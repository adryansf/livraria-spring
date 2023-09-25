package com.example.livraria.models;

import com.example.livraria.enums.SituacaoPedidoEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
import java.util.List;
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
  @JsonIgnoreProperties("pedido")
  private List<ItemModel> itens;

  @ManyToOne
  @JoinColumn(name = "idCliente", nullable = false)
  @JsonIgnoreProperties("pedidos")
  private ClienteModel cliente;
}
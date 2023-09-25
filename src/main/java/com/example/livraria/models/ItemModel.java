package com.example.livraria.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "itens")
public class ItemModel implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  private int quantidade;
  private double subtotal;

  @ManyToOne()
  @JoinColumn(name = "idLivro",  nullable = false)
  private LivroModel livro;

  @ManyToOne
  @JoinColumn(name = "idPedido", nullable = false)
  @JsonIgnoreProperties("itens")
  private PedidoModel pedido;
}
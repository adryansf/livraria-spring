package com.example.livraria.models;

public class PerfilConsumoModel {
    static int lastId = 0;


    private int id;
    private String generoFavorito;
    private String autorFavorito;

    public PerfilConsumoModel(String generoFavorito, String autorFavorito){
        this.generoFavorito = generoFavorito;
        this.autorFavorito = autorFavorito;

        // AUTO GERAÇÃO DE ID
        lastId++;
        this.id = lastId;
    }

    public int getId() {
      return id;
    }

    public String getGeneroFavorito() {
      return generoFavorito;
    }

    public String getAutorFavorito() {
      return autorFavorito;
    }

    public void setGeneroFavorito(String generoFavorito) {
      this.generoFavorito = generoFavorito;
    }

    public void setAutorFavorito(String autorFavorito) {
      this.autorFavorito = autorFavorito;
    }
}

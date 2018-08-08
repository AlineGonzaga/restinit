package com.teste.retrofit2apagar;

public class Produto {

      private int Id;
      private String Nome;
      private String Categoria;
      private String Preco;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
         Categoria = categoria;
    }

    public String getPreco() {
        return Preco;
    }

    public void setPreco(String preco) {
        Preco = preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "Id=" + Id +
                ", Nome='" + Nome + '\'' +
                ", Categoria='" + Categoria + '\'' +
                ", Preco='" + Preco + '\'' +
                '}';
    }
}
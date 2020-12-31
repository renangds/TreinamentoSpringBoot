package com.example.demo.domain;

import java.io.Serializable;
import java.util.Objects;

public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String nome;

    public Categoria(){

    }

    public Categoria(String nome, int id){
        this.setNome(nome);
        this.setId(id);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return id == categoria.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

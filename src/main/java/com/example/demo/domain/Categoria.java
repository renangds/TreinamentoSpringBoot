package com.example.demo.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    @ManyToMany(mappedBy = "categorias")
    private List<Produto> produtos = new ArrayList<>();

    public List<Produto> getProdutosList() {
        return produtos;
    }

    public void setProdutosList(List<Produto> produtosList) {
        this.produtos = produtosList;
    }

    public Categoria(){

    }

    public Categoria(String nome, Integer id){
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o){
            return true;
        }
        if(o == null)
            return false;
        if(this.getClass() != o.getClass())
            return false;
        Categoria other = (Categoria) o;
        if(this.id == null) {
            if(other.id != null){
                return false;
            }
        } else if(!this.id.equals(other.id)){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        return result;
    }
}

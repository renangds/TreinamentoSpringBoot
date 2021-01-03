package com.example.demo.services;

import com.example.demo.domain.Categoria;
import com.example.demo.repositories.CategoriaRepository;
import com.example.demo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria getCategoria(Integer categoriaId){
        Optional<Categoria> obj = this.categoriaRepository.findById((categoriaId));
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + categoriaId + ", Tipo: " + Categoria.class.getName()
        ));
    }
}
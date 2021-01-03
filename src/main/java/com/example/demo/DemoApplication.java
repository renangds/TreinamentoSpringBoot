package com.example.demo;

import com.example.demo.domain.Categoria;
import com.example.demo.domain.Produto;
import com.example.demo.repositories.CategoriaRepository;
import com.example.demo.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String...args){
        Produto p1 = new Produto(null, "Impressora", 800.00);
        Produto p2 = new Produto(null, "Mouse", 250.00);
        Produto p3 = new Produto(null, "Grampeador", 55.00);

        Categoria cat1 = new Categoria("Informática", null);
        Categoria cat2 = new Categoria("Escritório", null);

        cat1.getProdutosList().addAll(Arrays.asList(p1, p2));
        cat2.getProdutosList().addAll(Arrays.asList(p3));

        p1.getCategoriasList().addAll(Arrays.asList(cat1));
        p2.getCategoriasList().addAll(Arrays.asList(cat1, cat2));
        p3.getCategoriasList().addAll(Arrays.asList(cat1));

        this.categoriaRepository.saveAll(
                Arrays.asList(cat1, cat2)
        );

        this.produtoRepository.saveAll(
                Arrays.asList(p1, p2, p3)
        );
    }

}

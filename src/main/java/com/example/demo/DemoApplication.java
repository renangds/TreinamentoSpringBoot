package com.example.demo;

import com.example.demo.domain.Categoria;
import com.example.demo.domain.Cidade;
import com.example.demo.domain.Estado;
import com.example.demo.domain.Produto;
import com.example.demo.repositories.CategoriaRepository;
import com.example.demo.repositories.CidadeRepository;
import com.example.demo.repositories.EstadoRepository;
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

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String...args){
        Categoria cat1 = new Categoria("Informática", null);
        Categoria cat2 = new Categoria("Papelaria", null);

        Produto p1 = new Produto("Impressora", 800.00, null );
        Produto p2 = new Produto("Notebook", 3000.00, null );
        Produto p3 = new Produto("Memória 8GB", 150.00, null);

        cat1.getListProduto().addAll(Arrays.asList(p1, p2, p3));
        cat2.getListProduto().addAll(Arrays.asList(p1));

        p1.getCategoriaList().addAll(Arrays.asList(cat1, cat2));
        p2.getCategoriaList().addAll(Arrays.asList(cat2));
        p2.getCategoriaList().addAll(Arrays.asList(cat2));

        this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
        this.produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

        Estado e = new Estado(null, "Rio de Janeiro");
        Cidade c = new Cidade(null, "Rio de Janeiro", e);

        e.getCidades().addAll(Arrays.asList(c));

        this.estadoRepository.saveAll(Arrays.asList(e));
        this.cidadeRepository.saveAll(Arrays.asList(c));

    }

}

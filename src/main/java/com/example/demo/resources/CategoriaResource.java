package com.example.demo.resources;

import com.example.demo.domain.Categoria;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {

    @RequestMapping(method = RequestMethod.GET)
    public List<Categoria> getList(){
        Categoria[] c = { new Categoria("Informática", 2) };
        return Arrays.asList(c)
                .stream()
                .map(p -> {
                    p.setId(p.getId() + 1);
                    return p;
                })
                .collect(Collectors.toList());
    }
}

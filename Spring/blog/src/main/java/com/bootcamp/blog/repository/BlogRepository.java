package com.bootcamp.blog.repository;

import com.bootcamp.blog.model.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepository implements IBlogRepository{
    private List<EntradaBlog> listaEntradas;

    public BlogRepository() {
        this.listaEntradas = new ArrayList<>();
    }

    @Override
    public void insertarEntrada(EntradaBlog nuevaEntrada){
        this.listaEntradas.add(nuevaEntrada);
    }

    @Override
    //retrona null si no lo encuentra
    public EntradaBlog buscarEntrada(Integer id){
        return this.listaEntradas.stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<EntradaBlog> getAllEntradas(){
        return this.listaEntradas;
    }
}

package com.linktracker.demo.repository;

import com.linktracker.demo.model.Link;
import lombok.Builder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepository implements ILinkRepository{

    List<Link> listaLinks = new ArrayList<>();

    @Override
    public Integer agregarListaLinks(Link link){

        listaLinks.add(link);

        return listaLinks.indexOf(link);

    }

    @Override
    public Link findById(int idLink) throws RuntimeException{

        if(!listaLinks.isEmpty()){
            try{
                return listaLinks.get(idLink);
            }catch (Exception e) {
                throw new RuntimeException("No existe un link con el ID ingresado");
            }
        }

        throw new RuntimeException("La lista de URLs está vacía");
    }

}

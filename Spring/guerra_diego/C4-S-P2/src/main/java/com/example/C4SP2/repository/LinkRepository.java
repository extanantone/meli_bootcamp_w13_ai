package com.example.C4SP2.repository;

import com.example.C4SP2.model.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepository implements ILinkRepository{
    List<Link> listLinks = new ArrayList<>();

    @Override
    public Link crearLink(Link link) {

        link.setId(listLinks.size()+1);
        listLinks.add(link);
        return link;

    }

    public Link buscarLink(String url){
        return listLinks.stream()
                .filter(l -> l.getUrl().equals(url))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Link linkValido(Link link) {
        return listLinks.stream()
                .filter(l -> l.getId()==link.getId() && l.isValido())
                .findFirst()
                .orElse(null);
    }

    @Override
    public Link autenticar(Link link) {
        return listLinks.stream()
                .filter(l -> l.getId()==link.getId() && l.getPassword().equals(link.getPassword()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void aumentarMetrica(Link link) {
        Link filt = listLinks.stream()
                .filter(l -> l.getId()==link.getId())
                .findFirst().orElse(null);
        filt.aumentarMetrica();

    }

    @Override
    public Link getMetricas(int id) {

        return listLinks.stream()
                .filter(l -> l.getId()==id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Link invalidarLink(int id) {
        Link invalidLink = listLinks.stream()
                .filter(l -> l.getId()==id)
                .findFirst()
                .orElse(null);
        invalidLink.setValido(false);

        return invalidLink;
    }

}

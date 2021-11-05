package com.example.demo.repository;

import com.example.demo.dto.LinkDTO;
import com.example.demo.dto.LinkMetricsDTO;
import com.example.demo.dto.LinkUrlDTO;
import com.example.demo.model.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class LinkRepository implements ILinkRepository{

    private Map<Integer, Link> listaLinks = new HashMap<>();
    private Map<Integer, Link> accesoALinks = new HashMap<>();

    @Override
    public Link guardarLink(LinkUrlDTO url) {

        Link link = new Link(url.getUrl());
        listaLinks.put(link.getId(), link);

        return link;
    }

    @Override
    public List<Link> obtenerLinks() {
        return this.listaLinks.entrySet().stream().map(e -> {
            //e.getValue().setId(e.getKey());
            return e.getValue();
        }).collect(Collectors.toList());
    }

    @Override
    public Link obtenerLinkPorID(LinkDTO id) {

        Link response = new Link();
        response = listaLinks.get(id.getId());

        return response;
    }

    @Override
    public Integer obtenerAccesosPorLinkId(Integer linkId) {
        Link response = new Link();
        response = accesoALinks.get(linkId);

        return response.getAccesos();
    }

    @Override
    public void actualizarLink(Link link) {

        listaLinks.put(link.getId(), link);

    }


}

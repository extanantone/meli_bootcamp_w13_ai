package com.c4.p2.repository;

import com.c4.p2.model.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepository implements ILinkRepository{
    List<Link> links;

    public LinkRepository(){
        links = new ArrayList<>();
    }

    @Override
    public Integer nuevoLink(Link link) {
        int id = 0;
        if (links.size() > 0)
            id = links.get(links.size() -1 ).getId() + 1;
        link.setId(id);
        links.add(link);
        return id;
    }

    @Override
    public void actualizarLink(Link link) {
        int idx = links.indexOf(links.stream().filter(l -> l.getId().equals(link.getId())).findFirst().orElse(null));
        if (idx != -1)
            links.set(idx, link);
    }

    @Override
    public Link obtenerLink(Integer idLink) {
        return links.stream().filter(l -> l.getId().equals(idLink)).findFirst().orElse(null);
    }
}

package com.bootcamp.link_tracker.repository;

import com.bootcamp.link_tracker.model.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkTrackerRepository implements ILinkTrackerRepository{
    private List<Link> listaLinks;

    public LinkTrackerRepository() {
        this.listaLinks = new ArrayList<>();
    }

    @Override
    public Link buscarLink(Integer id) {
        Link linkBuscado = this.listaLinks.stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);
        return linkBuscado;
    }

    @Override
    public void guardarLink(Link link) {
        this.listaLinks.add(link);
    }

}

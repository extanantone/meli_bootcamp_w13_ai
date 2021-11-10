package com.Bootcamp.C4P2EJ1.repository;

import com.Bootcamp.C4P2EJ1.model.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class LinkRepositoryImp implements ILinkRepository {
    Map<Integer, Link> linkMapBD = new HashMap<>();

    @Override
    public Link insertLink(Link link) {
        this.linkMapBD.put(link.getId(), link);
        return link;
    }

    @Override
    public Link buscarLink(String password, Link link) {
        Link linkEncontrado = this.linkMapBD.values()
                .stream()
                .filter(l -> l.getPassword().equals(password) && l.getId().equals(link.getId()))
                .findFirst()
                .orElse(null);
        return linkEncontrado;
    }

    public Link buscarLinkSinPassword(Link link) {
        Link linkEncontrado = this.linkMapBD.values()
                .stream()
                .filter(l -> l.getId().equals(link.getId()))
                .findFirst()
                .orElse(null);
        if (linkEncontrado != null) {
            linkEncontrado.setContador(linkEncontrado.getContador() + 1);
            insertLink(linkEncontrado);
        }
        return linkEncontrado;
    }

    @Override
    public boolean eliminarLink(Link link) {
        Link linkResultado = this.linkMapBD.remove(link.getId());
        if (linkResultado == null) {
            return false;
        }
        return true;
    }
}

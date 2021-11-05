package com.example.linktracker.repository;

import com.example.linktracker.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class LinkRepositorio implements ILinkRepositorio {
    private final Map<Integer, Link> links = new HashMap<>();

    private int asignarId() {
        return links.size() + 1;
    }

    @Override
    public Link guardar(Link link) {
        link.setLinkId(asignarId());
        Link linkAntiguo = links.put(link.getLinkId(), link);
        if (linkAntiguo == null) return link;
        return linkAntiguo;
    }

    @Override
    public Link obtenerPorUrl(String url) {
        return null;
    }

    @Override
    public Link obtenerPorPassword(String pass) {
        Map.Entry<Integer, Link> linkEntry = links.entrySet()
                .stream()
                .filter(entry -> entry.getValue().getPassword().equals(pass))
                .findFirst()
                .orElse(null);

        if (linkEntry != null) return linkEntry.getValue();
        return null;
    }

    @Override
    public Link obtenerPorId(Integer id) {
        if (links.containsKey(id)) return links.get(id);
        return null;
    }
}

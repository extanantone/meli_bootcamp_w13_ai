package com.linktracker.repository;

import com.linktracker.model.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepository implements ILinkRepository {
    private List<Link> linksList = new ArrayList<>();

    @Override
    public int addLink(Link newLink) {
        linksList.add(newLink);
        return linksList.indexOf(newLink);
    }

    @Override
    public Link findById(int idLink) throws RuntimeException {

        if (!linksList.isEmpty()) {
            try {
                return linksList.get(idLink);
            } catch (Exception e) {
                throw new RuntimeException("No existe un link con el ID ingresado");
            }
        }

        throw new RuntimeException("La lista de URLs está vacía");
    }
}

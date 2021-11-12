package com.bootcamp.linktracker.repository;

import com.bootcamp.linktracker.model.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class LinkRepository implements ILinkRepository {

    private static Integer currentId;
    private Map<Integer, Link> links;

    public LinkRepository() {
        currentId = 1;
        this.links = new HashMap<>();
    }

    @Override
    public int createLink(Link link) {
        link.setId(currentId);
        links.put(currentId, link);
        currentId += 1;
        return link.getId();
    }

    @Override
    public Link getLink(int id) {
        return links.get(id);
    }

    @Override
    public void countVisit(int id) {
        Link link = links.get(id);
        link.setVisitsCount(link.getVisitsCount() + 1);
    }
}

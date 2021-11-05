package com.example.linktracker.repository;

import com.example.linktracker.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class LinkRepositoryImpl implements ILinkRepository {

    private Long counter;
    private Map<Long, Link> db;

    public LinkRepositoryImpl() {
        this.counter = 0L;
        this.db = new HashMap<>();
    }

    @Override
    public Link getLink(Long id) {
        return this.db.get(id);
    }

    @Override
    public Long saveLink(Link link) {
        Long nextID = this.counter;
        this.counter++;
        link.setVisits(0L);
        link.setActive(true);
        this.db.put(nextID, link);
        return nextID;
    }

    @Override
    public void incrementeVisits(Long id) {
        this.db.get(id).incrementVisits(1L);
    }

    @Override
    public void invalidateLink(Long id) {
        this.db.get(id).setActive(false);
    }
}

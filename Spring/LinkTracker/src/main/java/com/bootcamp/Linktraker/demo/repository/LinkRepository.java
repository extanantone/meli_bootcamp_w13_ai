package com.bootcamp.Linktraker.demo.repository;


import com.bootcamp.Linktraker.demo.model.Link;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@Repository
@Getter @Setter
public class LinkRepository implements ILinkRepository {

     private Map<Long, Link> linkMap = new HashMap<>();

    @Override
    public void setLink(Link link) {

        linkMap.put(link.getId(),link);
    }

    @Override
    public Link getLink(long id) {
        return linkMap.get(id);
    }

    @Override
    public void inhabilitarLink(long id) {

    }

    @Override
    public Map<Long, Link> getMapLink() {
        return linkMap;
    }
}

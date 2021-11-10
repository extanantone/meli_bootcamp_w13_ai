package com.example.linktracker.repository;

import com.example.linktracker.exceptions.NotFoundException;
import com.example.linktracker.exceptions.UnauthorizedRequest;
import com.example.linktracker.model.Link;
import com.example.linktracker.dto.LinkDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class LinkTrackerRepository implements IlinkTrackerRepository{

    private Integer id = 0;
    private Map<Integer, Link> links = new HashMap<>();

    public Link validateId(Integer id) throws NotFoundException{
        Link link = links.get(id);
        if(link == null) {
            throw new NotFoundException("No hay un link con id " + id);
        }
        return link;
    }

    @Override
    public Link createUrl(Link url) {
        Link link = new Link();
        id = id +1 ;
        link.setId(id);
        link.setUrl(url.getUrl());
        link.setPassword(url.getPassword());
        links.put(id,link);


        return link;
    }

    @Override
    public Link getlink(Integer id,String password) throws NotFoundException {
        Link link = validateLink(id);
        if(!link.getPassword().equals(password)){
            throw new UnauthorizedRequest("Password invalido");
        }
        if(!link.getStatus()){
            throw new NotFoundException("Link invalido");
        }

        link.addCount();
        links.put(id,link);
        return link;
    }

    @Override
    public Map<Integer, Link> linkList() {
        return links;
    }

    @Override
    public Link validateLink(Integer id) throws NotFoundException{
        Link link = validateId(id);
        link.setStatus(false);
        links.put(id,link);

        return link;
    }
}

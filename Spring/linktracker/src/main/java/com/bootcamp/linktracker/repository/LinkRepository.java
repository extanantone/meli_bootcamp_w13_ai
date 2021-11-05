package com.bootcamp.linktracker.repository;

import com.bootcamp.linktracker.model.Link;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class LinkRepository implements ILinkRepository{

    ArrayList<Link> linkList = new ArrayList();

    @Override
    public Link getLink(int id) {
        if(linkList.size() > id) {
            return linkList.get(id);
        }
        return null;
    }

    @Override
    public int newLink(Link link) {
        linkList.add(link);
        return linkList.size() - 1;
    }
}

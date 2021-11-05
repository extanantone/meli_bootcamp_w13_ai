package com.example.redirect.repository;

import com.example.redirect.model.Link;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class RepositoryLink implements IRepositoryLink {
    Integer idLink = 0;
    Map<Integer, Link> hashLinks = new HashMap<>();
    Set<String> listUrls = new HashSet<>();

    @Override
    public Integer create(Link link) {
       if (!listUrls.contains(link.getUrl())){
            hashLinks.put(++idLink, link);
           listUrls.add(link.getUrl());
           return idLink;
       }else{
           return -1;
       }
    }

    @Override
    public Link getLinkById(Integer id, String pass) {
        if (hashLinks.containsKey(id)){
            if (pass.equals(hashLinks.get(id).getPass())){
                return hashLinks.get(id);
            }
        };
        return null;
    }

    @Override
    public Integer getMetrics(Integer linkid) {
        Link link = hashLinks.get(linkid);
        if ( !(link == null) ){
            return link.getMetrics();
        }
        return null;
    }

    @Override
    public String invalidateLink(Integer id) {
        if (hashLinks.containsKey(id)){
            listUrls.remove(hashLinks.get(id).getUrl());
            hashLinks.remove(id);
            return "Link invalidado";
        };
        return null;
    }
}
